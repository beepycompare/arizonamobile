package com.arizonagames.feature.arizona.imageviewer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: WelcomeBannerUrlResolver.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannerUrlResolver;", "", "<init>", "()V", "resolve", "", "imagePath", "projectResourceUrl", "PROJECTS_PATH_PREFIX", "PROJECTS_PATH_MARKER", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WelcomeBannerUrlResolver {
    public static final WelcomeBannerUrlResolver INSTANCE = new WelcomeBannerUrlResolver();
    private static final String PROJECTS_PATH_MARKER = "/projects/";
    private static final String PROJECTS_PATH_PREFIX = "projects/";

    private WelcomeBannerUrlResolver() {
    }

    public final String resolve(String imagePath, String projectResourceUrl) {
        Intrinsics.checkNotNullParameter(imagePath, "imagePath");
        Intrinsics.checkNotNullParameter(projectResourceUrl, "projectResourceUrl");
        String obj = StringsKt.trim((CharSequence) imagePath).toString();
        if (StringsKt.startsWith$default(obj, "https://", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "http://", false, 2, (Object) null)) {
            return obj;
        }
        String trimEnd = StringsKt.trimEnd(StringsKt.trim((CharSequence) projectResourceUrl).toString(), '/');
        if (StringsKt.isBlank(trimEnd)) {
            trimEnd = null;
        }
        if (trimEnd == null) {
            return null;
        }
        String trimStart = StringsKt.trimStart(obj, '/');
        if (StringsKt.startsWith$default(trimStart, PROJECTS_PATH_PREFIX, false, 2, (Object) null)) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) trimEnd, PROJECTS_PATH_MARKER, 0, false, 6, (Object) null);
            if (indexOf$default >= 0) {
                trimEnd = trimEnd.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(trimEnd, "substring(...)");
            }
            return trimEnd + "/" + trimStart;
        }
        return trimEnd + "/" + trimStart;
    }
}
