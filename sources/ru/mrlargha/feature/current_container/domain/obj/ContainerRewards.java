package ru.mrlargha.feature.current_container.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ContainerRewards.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/feature/current_container/domain/obj/ContainerRewards;", "", "tittle", "", "title", "image", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getTittle", "()Ljava/lang/String;", "getTitle", "getImage", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "current-container"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ContainerRewards {
    private final int image;
    private final String title;
    private final String tittle;

    public static /* synthetic */ ContainerRewards copy$default(ContainerRewards containerRewards, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = containerRewards.tittle;
        }
        if ((i2 & 2) != 0) {
            str2 = containerRewards.title;
        }
        if ((i2 & 4) != 0) {
            i = containerRewards.image;
        }
        return containerRewards.copy(str, str2, i);
    }

    public final String component1() {
        return this.tittle;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.image;
    }

    public final ContainerRewards copy(String tittle, String title, int i) {
        Intrinsics.checkNotNullParameter(tittle, "tittle");
        Intrinsics.checkNotNullParameter(title, "title");
        return new ContainerRewards(tittle, title, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContainerRewards) {
            ContainerRewards containerRewards = (ContainerRewards) obj;
            return Intrinsics.areEqual(this.tittle, containerRewards.tittle) && Intrinsics.areEqual(this.title, containerRewards.title) && this.image == containerRewards.image;
        }
        return false;
    }

    public int hashCode() {
        return (((this.tittle.hashCode() * 31) + this.title.hashCode()) * 31) + Integer.hashCode(this.image);
    }

    public String toString() {
        String str = this.tittle;
        String str2 = this.title;
        return "ContainerRewards(tittle=" + str + ", title=" + str2 + ", image=" + this.image + ")";
    }

    public ContainerRewards(String tittle, String title, int i) {
        Intrinsics.checkNotNullParameter(tittle, "tittle");
        Intrinsics.checkNotNullParameter(title, "title");
        this.tittle = tittle;
        this.title = title;
        this.image = i;
    }

    public final String getTittle() {
        return this.tittle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getImage() {
        return this.image;
    }
}
