/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * Credits goes to all Open Source Core Developer Groups listed below
 * Please do not change here something, ragarding the developer credits, except the "developed by XXXX".
 * Even if you edit a lot of files in this source, you still have no rights to call it as "your Core".
 * Everybody knows that this Emulator Core was developed by Aion Lightning 
 * @-Aion-Unique-
 * @-Aion-Lightning
 * @Aion-Engine
 * @Aion-Extreme
 * @Aion-NextGen
 * @Aion-Core Dev.
 */
package com.aionemu.commons.scripting;

import com.aionemu.commons.scripting.impl.ScriptContextImpl;

import java.io.File;

/**
 * This class is script context provider. We can switch to any other
 * ScriptContext implementation later, so it's good to have factory class
 *
 * @author SoulKeeper
 */
public final class ScriptContextFactory {

    /**
     * Creates script context, sets the root context. Adds child context if
     * needed
     *
     * @param root   file that will be threated as root for compiler
     * @param parent parent of new ScriptContext
     * @return ScriptContext with presetted root file
     * @throws InstantiationException if java compiler is not aviable
     */
    public static ScriptContext getScriptContext(File root, ScriptContext parent) throws InstantiationException {
        ScriptContextImpl ctx;
        if (parent == null) {
            ctx = new ScriptContextImpl(root);
        } else {
            ctx = new ScriptContextImpl(root, parent);
            parent.addChildScriptContext(ctx);
        }
        return ctx;
    }
}
