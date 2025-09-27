package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options;

import android.content.Context;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: IFramePlayerOptions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\r\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "", "playerOptions", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "toString", "", "getOrigin", "getOrigin$core_release", "Companion", "Builder", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IFramePlayerOptions {
    public static final Companion Companion = new Companion(null);
    private final JSONObject playerOptions;

    public /* synthetic */ IFramePlayerOptions(JSONObject jSONObject, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject);
    }

    private IFramePlayerOptions(JSONObject jSONObject) {
        this.playerOptions = jSONObject;
    }

    /* compiled from: IFramePlayerOptions.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions$Companion;", "", "<init>", "()V", "getDefault", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "context", "Landroid/content/Context;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IFramePlayerOptions getDefault(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Builder(context).controls(1).build();
        }
    }

    public String toString() {
        String jSONObject = this.playerOptions.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return jSONObject;
    }

    public final String getOrigin$core_release() {
        String string = this.playerOptions.getString("origin");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* compiled from: IFramePlayerOptions.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000bH\u0007J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "builderOptions", "Lorg/json/JSONObject;", "build", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", Builder.CONTROLS, "", Builder.AUTO_PLAY, Builder.MUTE, Builder.REL, "ivLoadPolicy", "langPref", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "", "ccLoadPolicy", "origin", Builder.LIST, Builder.LIST_TYPE, "fullscreen", Builder.FS, "start", "startSeconds", "end", "endSeconds", "modestBranding", "addString", "", "key", "value", "addInt", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {
        private static final String AUTO_PLAY = "autoplay";
        private static final String CC_LANG_PREF = "cc_lang_pref";
        private static final String CC_LOAD_POLICY = "cc_load_policy";
        private static final String CONTROLS = "controls";
        public static final Companion Companion = new Companion(null);
        private static final String ENABLE_JS_API = "enablejsapi";
        private static final String END = "end";
        private static final String FS = "fs";
        private static final String IV_LOAD_POLICY = "iv_load_policy";
        private static final String LIST = "list";
        private static final String LIST_TYPE = "listType";
        private static final String MUTE = "mute";
        public static final String ORIGIN = "origin";
        private static final String REL = "rel";
        private static final String START = "start";
        private final JSONObject builderOptions;

        @Deprecated(message = "Deprecated and will have no effect")
        public final Builder modestBranding(int i) {
            return this;
        }

        /* compiled from: IFramePlayerOptions.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions$Builder$Companion;", "", "<init>", "()V", "AUTO_PLAY", "", "MUTE", "CONTROLS", "ENABLE_JS_API", "FS", "ORIGIN", "REL", "IV_LOAD_POLICY", "CC_LOAD_POLICY", "CC_LANG_PREF", "LIST", "LIST_TYPE", "START", "END", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.builderOptions = new JSONObject();
            addInt(AUTO_PLAY, 0);
            addInt(MUTE, 0);
            addInt(CONTROLS, 0);
            addInt(ENABLE_JS_API, 1);
            addInt(FS, 0);
            addString("origin", "https://" + context.getPackageName());
            addInt(REL, 0);
            addInt(IV_LOAD_POLICY, 3);
            addInt(CC_LOAD_POLICY, 0);
        }

        public final IFramePlayerOptions build() {
            return new IFramePlayerOptions(this.builderOptions, null);
        }

        public final Builder controls(int i) {
            addInt(CONTROLS, i);
            return this;
        }

        public final Builder autoplay(int i) {
            addInt(AUTO_PLAY, i);
            return this;
        }

        public final Builder mute(int i) {
            addInt(MUTE, i);
            return this;
        }

        public final Builder rel(int i) {
            addInt(REL, i);
            return this;
        }

        public final Builder ivLoadPolicy(int i) {
            addInt(IV_LOAD_POLICY, i);
            return this;
        }

        public final Builder langPref(String languageCode) {
            Intrinsics.checkNotNullParameter(languageCode, "languageCode");
            addString(CC_LANG_PREF, languageCode);
            return this;
        }

        public final Builder ccLoadPolicy(int i) {
            addInt(CC_LOAD_POLICY, i);
            return this;
        }

        public final Builder origin(String origin) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            addString("origin", origin);
            return this;
        }

        public final Builder list(String list) {
            Intrinsics.checkNotNullParameter(list, "list");
            addString(LIST, list);
            return this;
        }

        public final Builder listType(String listType) {
            Intrinsics.checkNotNullParameter(listType, "listType");
            addString(LIST_TYPE, listType);
            return this;
        }

        public final Builder fullscreen(int i) {
            addInt(FS, i);
            return this;
        }

        public final Builder start(int i) {
            addInt("start", i);
            return this;
        }

        public final Builder end(int i) {
            addInt("end", i);
            return this;
        }

        private final void addString(String str, String str2) {
            try {
                this.builderOptions.put(str, str2);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + str + ": " + str2);
            }
        }

        private final void addInt(String str, int i) {
            try {
                this.builderOptions.put(str, i);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + str + ": " + i);
            }
        }
    }
}
