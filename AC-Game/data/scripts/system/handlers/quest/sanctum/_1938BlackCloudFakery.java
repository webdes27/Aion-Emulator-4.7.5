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
package quest.sanctum;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.questEngine.handlers.QuestHandler;
import com.aionemu.gameserver.model.DialogAction;
import com.aionemu.gameserver.questEngine.model.QuestEnv;
import com.aionemu.gameserver.questEngine.model.QuestState;
import com.aionemu.gameserver.questEngine.model.QuestStatus;

/**
 * @author zhkchi
 *
 */
public class _1938BlackCloudFakery extends QuestHandler {

    private final static int questId = 1938;
    private final static int[] npcs = {203703, 279001, 279008};

    public _1938BlackCloudFakery() {
        super(questId);
    }

    @Override
    public void register() {
        qe.registerQuestNpc(203703).addOnQuestStart(questId);
        for (int npc : npcs) {
            qe.registerQuestNpc(npc).addOnTalkEvent(questId);
        }
    }

    @Override
    public boolean onDialogEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        int targetId = env.getTargetId();
        DialogAction dialog = env.getDialog();

        if (sendQuestNoneDialog(env, 203703)) {
            return true;
        }

        if (qs == null) {
            return false;
        }

        int var = qs.getQuestVarById(0);

        if (qs.getStatus() == QuestStatus.START) {
            switch (targetId) {
                case 279001:
                    switch (dialog) {
                        case QUEST_SELECT:
                            if (var == 0) {
                                return sendQuestDialog(env, 1352);
                            }
                        case SETPRO1:
                            return defaultCloseDialog(env, 0, 1);
                    }
                    break;
                case 279008:
                    switch (dialog) {
                        case QUEST_SELECT:
                            if (var == 1) {
                                return sendQuestDialog(env, 1693);
                            }
                        case SETPRO2:
                            return defaultCloseDialog(env, 1, 2, true, false);
                    }
                    break;
            }
        }
        return sendQuestRewardDialog(env, 203703, 2375);
    }
}
