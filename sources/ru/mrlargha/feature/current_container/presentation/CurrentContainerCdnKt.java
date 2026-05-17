package ru.mrlargha.feature.current_container.presentation;

import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import kotlin.Metadata;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: CurrentContainerCdn.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\b\u0010\t\u001a\u00020\u0001H\u0002\u001a\b\u0010\n\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"ARIZONA_CONTAINER_CDN_PATH", "", "RODINA_CONTAINER_CDN_PATH", "ARIZONA_ITEM_CDN_PATH", "RODINA_ITEM_CDN_PATH", "getContainerImageUrl", "image", "", "getItemImageUrl", "getContainerCdnPath", "getItemCdnPath", "current-container"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CurrentContainerCdnKt {
    private static final String ARIZONA_CONTAINER_CDN_PATH = "systems/container/";
    private static final String ARIZONA_ITEM_CDN_PATH = "assets/images/donate/";
    private static final String RODINA_CONTAINER_CDN_PATH = "systems/container/";
    private static final String RODINA_ITEM_CDN_PATH = "systems/battlepass/items/";

    public static final String getContainerImageUrl(int i) {
        String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        return projectResourceUrl$default + getContainerCdnPath() + i + ".webp";
    }

    public static final String getItemImageUrl(int i) {
        String projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
        return projectResourceUrl$default + getItemCdnPath() + i + ".webp";
    }

    private static final String getContainerCdnPath() {
        UtilsKt.isArizonaType();
        return "systems/container/";
    }

    private static final String getItemCdnPath() {
        return UtilsKt.isArizonaType() ? ARIZONA_ITEM_CDN_PATH : RODINA_ITEM_CDN_PATH;
    }
}
