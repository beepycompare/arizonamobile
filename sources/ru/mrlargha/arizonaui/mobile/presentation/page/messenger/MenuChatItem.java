package ru.mrlargha.arizonaui.mobile.presentation.page.messenger;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MessengerChat.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MenuChatItem;", "", "id", "Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MenuId;", "icon", "", "name", "", "textColor", "<init>", "(Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MenuId;ILjava/lang/String;I)V", "getId", "()Lru/mrlargha/arizonaui/mobile/presentation/page/messenger/MenuId;", "getIcon", "()I", "getName", "()Ljava/lang/String;", "getTextColor", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
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
