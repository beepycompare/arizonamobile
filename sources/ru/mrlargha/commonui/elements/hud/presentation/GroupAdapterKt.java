package ru.mrlargha.commonui.elements.hud.presentation;

import kotlin.Metadata;
import ru.mrlargha.commonui.elements.hud.presentation.models.GroupItem;
/* compiled from: GroupAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0003"}, d2 = {"updateWith", "Lru/mrlargha/commonui/elements/hud/presentation/models/GroupItem;", "newData", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupItem updateWith(GroupItem groupItem, GroupItem groupItem2) {
        String name = groupItem2.getName();
        if (name == null) {
            name = groupItem.getName();
        }
        String str = name;
        Integer health = groupItem2.getHealth();
        if (health == null) {
            health = groupItem.getHealth();
        }
        Integer num = health;
        Integer armor = groupItem2.getArmor();
        if (armor == null) {
            armor = groupItem.getArmor();
        }
        return GroupItem.copy$default(groupItem, 0, str, num, armor, 1, null);
    }
}
