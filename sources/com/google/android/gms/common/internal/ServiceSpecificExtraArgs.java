package com.google.android.gms.common.internal;
/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public final class ServiceSpecificExtraArgs {

    /* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
    /* loaded from: classes3.dex */
    public interface CastExtraArgs {
        public static final String LISTENER = "listener";
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
    /* loaded from: classes3.dex */
    public interface GamesExtraArgs {
        public static final String DESIRED_LOCALE = "com.google.android.gms.games.key.desiredLocale";
        public static final String GAME_PACKAGE_NAME = "com.google.android.gms.games.key.gamePackageName";
        public static final String SIGNIN_OPTIONS = "com.google.android.gms.games.key.signInOptions";
        public static final String WINDOW_TOKEN = "com.google.android.gms.games.key.popupWindowToken";
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
    /* loaded from: classes3.dex */
    public interface PlusExtraArgs {
        public static final String PLUS_AUTH_PACKAGE = "auth_package";
    }

    private ServiceSpecificExtraArgs() {
    }
}
