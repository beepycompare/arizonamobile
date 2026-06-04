package ru.mrlargha.feature.mobile.presentation.page.messenger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MessengerChat.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\b\u0001\u0010\u0004\u001a\u00020\u0005:\u0002\b\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/messenger/MenuChatItem;", "", "id", "Lru/mrlargha/feature/mobile/presentation/page/messenger/MenuId;", "icon", "", "Landroidx/annotation/DrawableRes;", "name", "", "textColor", "<init>", "(Lru/mrlargha/feature/mobile/presentation/page/messenger/MenuId;ILjava/lang/String;I)V", "getId", "()Lru/mrlargha/feature/mobile/presentation/page/messenger/MenuId;", "getIcon", "()I", "getName", "()Ljava/lang/String;", "getTextColor", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MenuChatItem {
    private final int icon;
    private final MenuId id;
    private final String name;
    private final int textColor;

    public MenuChatItem(MenuId id, int i, String name, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.icon = i;
        this.name = name;
        this.textColor = i2;
    }

    public final MenuId getId() {
        return this.id;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final int getTextColor() {
        return this.textColor;
    }
}
