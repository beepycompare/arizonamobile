package ru.mrlargha.commonui.elements.animation.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AnimationCategory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J.\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/animation/domain/obj/AnimationCategory;", "", "id", "", "name", "", "isEnabled", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "()Z", "setEnabled", "(Z)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Z)Lru/mrlargha/commonui/elements/animation/domain/obj/AnimationCategory;", "equals", "other", "hashCode", "toString", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnimationCategory {
    private final Integer id;
    private boolean isEnabled;
    private final String name;

    public static /* synthetic */ AnimationCategory copy$default(AnimationCategory animationCategory, Integer num, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            num = animationCategory.id;
        }
        if ((i & 2) != 0) {
            str = animationCategory.name;
        }
        if ((i & 4) != 0) {
            z = animationCategory.isEnabled;
        }
        return animationCategory.copy(num, str, z);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.isEnabled;
    }

    public final AnimationCategory copy(Integer num, String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new AnimationCategory(num, name, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnimationCategory) {
            AnimationCategory animationCategory = (AnimationCategory) obj;
            return Intrinsics.areEqual(this.id, animationCategory.id) && Intrinsics.areEqual(this.name, animationCategory.name) && this.isEnabled == animationCategory.isEnabled;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.id;
        return ((((num == null ? 0 : num.hashCode()) * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.isEnabled);
    }

    public String toString() {
        Integer num = this.id;
        String str = this.name;
        return "AnimationCategory(id=" + num + ", name=" + str + ", isEnabled=" + this.isEnabled + ")";
    }

    public AnimationCategory(Integer num, String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = num;
        this.name = name;
        this.isEnabled = z;
    }

    public /* synthetic */ AnimationCategory(Integer num, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, (i & 4) != 0 ? false : z);
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }
}
