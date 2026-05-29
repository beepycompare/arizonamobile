package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.gathers_count;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HudGathersCountModel.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0010J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountDebuff;", "", "type", "", "icon", "title", "time", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getType", "()Ljava/lang/String;", "getIcon", "getTitle", "getTime", "()I", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/gathers_count/HudGathersCountDebuffType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HudGathersCountDebuff {
    private final String icon;
    private final int time;
    private final String title;
    private final String type;

    public static /* synthetic */ HudGathersCountDebuff copy$default(HudGathersCountDebuff hudGathersCountDebuff, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hudGathersCountDebuff.type;
        }
        if ((i2 & 2) != 0) {
            str2 = hudGathersCountDebuff.icon;
        }
        if ((i2 & 4) != 0) {
            str3 = hudGathersCountDebuff.title;
        }
        if ((i2 & 8) != 0) {
            i = hudGathersCountDebuff.time;
        }
        return hudGathersCountDebuff.copy(str, str2, str3, i);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.time;
    }

    public final HudGathersCountDebuff copy(String type, String icon, String title, int i) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        return new HudGathersCountDebuff(type, icon, title, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HudGathersCountDebuff) {
            HudGathersCountDebuff hudGathersCountDebuff = (HudGathersCountDebuff) obj;
            return Intrinsics.areEqual(this.type, hudGathersCountDebuff.type) && Intrinsics.areEqual(this.icon, hudGathersCountDebuff.icon) && Intrinsics.areEqual(this.title, hudGathersCountDebuff.title) && this.time == hudGathersCountDebuff.time;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.type.hashCode() * 31) + this.icon.hashCode()) * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.time);
    }

    public String toString() {
        String str = this.type;
        String str2 = this.icon;
        String str3 = this.title;
        return "HudGathersCountDebuff(type=" + str + ", icon=" + str2 + ", title=" + str3 + ", time=" + this.time + ")";
    }

    public HudGathersCountDebuff(String type, String icon, String title, int i) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        this.type = type;
        this.icon = icon;
        this.title = title;
        this.time = i;
    }

    public final String getType() {
        return this.type;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTime() {
        return this.time;
    }

    /* renamed from: getType  reason: collision with other method in class */
    public final HudGathersCountDebuffType m11773getType() {
        Object obj;
        Iterator<E> it = HudGathersCountDebuffType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((HudGathersCountDebuffType) obj).getType(), this.type)) {
                break;
            }
        }
        HudGathersCountDebuffType hudGathersCountDebuffType = (HudGathersCountDebuffType) obj;
        return hudGathersCountDebuffType == null ? HudGathersCountDebuffType.FROZEN : hudGathersCountDebuffType;
    }
}
