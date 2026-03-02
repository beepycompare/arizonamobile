package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_game.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudChickenGameInfoModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/models/HudChickenGameModel;", "", "title", "", "tools", "", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_game/models/HudChickenGameToolsModel;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getTools", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudChickenGameModel {
    private final String title;
    private final List<HudChickenGameToolsModel> tools;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HudChickenGameModel copy$default(HudChickenGameModel hudChickenGameModel, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hudChickenGameModel.title;
        }
        if ((i & 2) != 0) {
            list = hudChickenGameModel.tools;
        }
        return hudChickenGameModel.copy(str, list);
    }

    public final String component1() {
        return this.title;
    }

    public final List<HudChickenGameToolsModel> component2() {
        return this.tools;
    }

    public final HudChickenGameModel copy(String title, List<HudChickenGameToolsModel> tools) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(tools, "tools");
        return new HudChickenGameModel(title, tools);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudChickenGameModel) {
            HudChickenGameModel hudChickenGameModel = (HudChickenGameModel) obj;
            return Intrinsics.areEqual(this.title, hudChickenGameModel.title) && Intrinsics.areEqual(this.tools, hudChickenGameModel.tools);
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.tools.hashCode();
    }

    public String toString() {
        String str = this.title;
        return "HudChickenGameModel(title=" + str + ", tools=" + this.tools + ")";
    }

    public HudChickenGameModel(String title, List<HudChickenGameToolsModel> tools) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(tools, "tools");
        this.title = title;
        this.tools = tools;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<HudChickenGameToolsModel> getTools() {
        return this.tools;
    }
}
