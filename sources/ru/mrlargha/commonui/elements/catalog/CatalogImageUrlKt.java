package ru.mrlargha.commonui.elements.catalog;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: CatalogImageUrl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a,\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DEFAULT_RODINA_CATALOG_IMAGE_PATH", "", "buildCatalogImageUrl", "projectResourceUrl", "imageName", "itemBasePath", "catalogBasePath", "normalizedCatalogPath", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CatalogImageUrlKt {
    private static final String DEFAULT_RODINA_CATALOG_IMAGE_PATH = "systems/battlepass/items";

    public static final String buildCatalogImageUrl(String projectResourceUrl, String imageName, String str, String str2) {
        Intrinsics.checkNotNullParameter(projectResourceUrl, "projectResourceUrl");
        Intrinsics.checkNotNullParameter(imageName, "imageName");
        String normalizedCatalogPath = normalizedCatalogPath(str);
        if (normalizedCatalogPath == null && (normalizedCatalogPath = normalizedCatalogPath(str2)) == null) {
            normalizedCatalogPath = DEFAULT_RODINA_CATALOG_IMAGE_PATH;
        }
        return StringsKt.trimEnd(projectResourceUrl, '/') + "/" + StringsKt.trim(normalizedCatalogPath, '/') + "/" + StringsKt.trimStart(imageName, '/');
    }

    private static final String normalizedCatalogPath(String str) {
        String obj;
        if (str == null || (obj = StringsKt.trim((CharSequence) str).toString()) == null || obj.length() <= 0) {
            return null;
        }
        return obj;
    }
}
