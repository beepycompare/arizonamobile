package com.arizonagames.feature.arizona.imageviewer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WelcomeBannersApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannerDto;", "", "imagePath", "", "<init>", "(Ljava/lang/String;)V", "getImagePath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WelcomeBannerDto {
    private final String imagePath;

    public static /* synthetic */ WelcomeBannerDto copy$default(WelcomeBannerDto welcomeBannerDto, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = welcomeBannerDto.imagePath;
        }
        return welcomeBannerDto.copy(str);
    }

    public final String component1() {
        return this.imagePath;
    }

    public final WelcomeBannerDto copy(String str) {
        return new WelcomeBannerDto(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WelcomeBannerDto) && Intrinsics.areEqual(this.imagePath, ((WelcomeBannerDto) obj).imagePath);
    }

    public int hashCode() {
        String str = this.imagePath;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "WelcomeBannerDto(imagePath=" + this.imagePath + ")";
    }

    public WelcomeBannerDto(String str) {
        this.imagePath = str;
    }

    public final String getImagePath() {
        return this.imagePath;
    }
}
