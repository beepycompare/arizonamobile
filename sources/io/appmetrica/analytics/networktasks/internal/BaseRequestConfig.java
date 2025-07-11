package io.appmetrica.analytics.networktasks.internal;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import io.appmetrica.analytics.coreapi.internal.identifiers.AppSetId;
import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.coreapi.internal.model.SdkEnvironment;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public class BaseRequestConfig {

    /* renamed from: a  reason: collision with root package name */
    private String f1232a;
    private SdkEnvironment b;
    private SdkIdentifiers c;
    private AppSetId d;
    private RetryPolicyConfig e;

    /* loaded from: classes4.dex */
    public static abstract class BaseRequestArguments<I, O> implements ArgumentsMerger<I, O> {
    }

    /* loaded from: classes4.dex */
    public static abstract class ComponentLoader<T extends BaseRequestConfig, A extends BaseRequestArguments, D extends DataSource<A>> implements RequestConfigLoader<T, D> {

        /* renamed from: a  reason: collision with root package name */
        final Context f1233a;
        final String b;

        /* JADX INFO: Access modifiers changed from: protected */
        public ComponentLoader(Context context, String str) {
            this.f1233a = context;
            this.b = str;
        }

        protected abstract T createBlankConfig();

        public Context getContext() {
            return this.f1233a;
        }

        public String getPackageName() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
        public /* bridge */ /* synthetic */ BaseRequestConfig load(Object obj) {
            return load((ComponentLoader<T, A, D>) ((DataSource) obj));
        }

        public T load(D d) {
            T createBlankConfig = createBlankConfig();
            createBlankConfig.setSdkIdentifiers(d.sdkIdentifiers);
            createBlankConfig.setSdkEnvironment(d.sdkEnvironmentProvider.getSdkEnvironment());
            createBlankConfig.setAppSetId(d.platformIdentifiers.getAppSetIdProvider().getAppSetId());
            createBlankConfig.setPackageName(this.b);
            return createBlankConfig;
        }
    }

    /* loaded from: classes4.dex */
    public static class DataSource<A> {
        public final A componentArguments;
        public final PlatformIdentifiers platformIdentifiers;
        public final SdkEnvironmentProvider sdkEnvironmentProvider;
        public final SdkIdentifiers sdkIdentifiers;

        public DataSource(SdkIdentifiers sdkIdentifiers, SdkEnvironmentProvider sdkEnvironmentProvider, PlatformIdentifiers platformIdentifiers, A a2) {
            this.sdkIdentifiers = sdkIdentifiers;
            this.componentArguments = a2;
            this.sdkEnvironmentProvider = sdkEnvironmentProvider;
            this.platformIdentifiers = platformIdentifiers;
        }
    }

    /* loaded from: classes4.dex */
    public interface RequestConfigLoader<T extends BaseRequestConfig, D> {
        T load(D d);
    }

    public String getAnalyticsSdkBuildNumber() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getSdkInfo().getSdkBuildNumber();
    }

    public String getAnalyticsSdkBuildType() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getSdkInfo().getSdkBuildType();
    }

    public String getAnalyticsSdkVersionName() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getSdkInfo().getSdkVersionName();
    }

    public String getAppBuildNumber() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getAppVersionInfo().getAppBuildNumber();
    }

    public String getAppFramework() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getAppFramework();
    }

    public String getAppPlatform() {
        return ConstantDeviceInfo.APP_PLATFORM;
    }

    public synchronized String getAppSetId() {
        AppSetId appSetId;
        appSetId = this.d;
        return (appSetId == null || appSetId.getId() == null) ? "" : this.d.getId();
    }

    public synchronized String getAppSetIdScope() {
        AppSetId appSetId;
        appSetId = this.d;
        return appSetId == null ? "" : appSetId.getScope().getValue();
    }

    public String getAppVersion() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment == null ? "" : sdkEnvironment.getAppVersionInfo().getAppVersionName();
    }

    public synchronized String getDeviceIDHash() {
        String str;
        str = "";
        SdkIdentifiers sdkIdentifiers = this.c;
        if (sdkIdentifiers != null && sdkIdentifiers.getDeviceIdHash() != null) {
            str = this.c.getDeviceIdHash();
        }
        return str;
    }

    public synchronized String getDeviceId() {
        String str;
        str = "";
        SdkIdentifiers sdkIdentifiers = this.c;
        if (sdkIdentifiers != null && sdkIdentifiers.getDeviceId() != null) {
            str = this.c.getDeviceId();
        }
        return str;
    }

    public String getDeviceRootStatus() {
        return ConstantDeviceInfo.DEVICE_ROOT_STATUS;
    }

    public String getDeviceType() {
        SdkEnvironment sdkEnvironment = this.b;
        return sdkEnvironment != null ? sdkEnvironment.getDeviceType() : "phone";
    }

    public String getManufacturer() {
        return (String) WrapUtils.getOrDefault(ConstantDeviceInfo.MANUFACTURER, "");
    }

    public String getModel() {
        return ConstantDeviceInfo.MODEL;
    }

    public int getOsApiLevel() {
        return ConstantDeviceInfo.OS_API_LEVEL;
    }

    public String getOsVersion() {
        return ConstantDeviceInfo.OS_VERSION;
    }

    public String getPackageName() {
        return this.f1232a;
    }

    public String getProtocolVersion() {
        return ExifInterface.GPS_MEASUREMENT_2D;
    }

    public RetryPolicyConfig getRetryPolicyConfig() {
        return this.e;
    }

    public float getScaleFactor() {
        SdkEnvironment sdkEnvironment = this.b;
        if (sdkEnvironment == null) {
            return 0.0f;
        }
        return sdkEnvironment.getScreenInfo().getScaleFactor();
    }

    public int getScreenDpi() {
        SdkEnvironment sdkEnvironment = this.b;
        if (sdkEnvironment == null) {
            return 0;
        }
        return sdkEnvironment.getScreenInfo().getDpi();
    }

    public int getScreenHeight() {
        SdkEnvironment sdkEnvironment = this.b;
        if (sdkEnvironment == null) {
            return 0;
        }
        return sdkEnvironment.getScreenInfo().getHeight();
    }

    public int getScreenWidth() {
        SdkEnvironment sdkEnvironment = this.b;
        if (sdkEnvironment == null) {
            return 0;
        }
        return sdkEnvironment.getScreenInfo().getWidth();
    }

    public synchronized String getUuid() {
        String str;
        str = "";
        SdkIdentifiers sdkIdentifiers = this.c;
        if (sdkIdentifiers != null && sdkIdentifiers.getUuid() != null) {
            str = this.c.getUuid();
        }
        return str;
    }

    public synchronized boolean isIdentifiersValid() {
        boolean z;
        String uuid;
        String deviceId;
        String deviceIdHash;
        SdkIdentifiers sdkIdentifiers = this.c;
        if (sdkIdentifiers != null && (uuid = sdkIdentifiers.getUuid()) != null && uuid.length() != 0 && (deviceId = sdkIdentifiers.getDeviceId()) != null && deviceId.length() != 0 && (deviceIdHash = sdkIdentifiers.getDeviceIdHash()) != null) {
            z = deviceIdHash.length() != 0;
        }
        return z;
    }

    protected void setAppSetId(AppSetId appSetId) {
        this.d = appSetId;
    }

    protected void setPackageName(String str) {
        this.f1232a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRetryPolicyConfig(RetryPolicyConfig retryPolicyConfig) {
        this.e = retryPolicyConfig;
    }

    protected void setSdkEnvironment(SdkEnvironment sdkEnvironment) {
        this.b = sdkEnvironment;
    }

    protected void setSdkIdentifiers(SdkIdentifiers sdkIdentifiers) {
        this.c = sdkIdentifiers;
    }

    public String toString() {
        return "BaseRequestConfig{mPackageName='" + this.f1232a + "', sdkEnvironment=" + this.b + ", mProtocolVersion='2', sdkIdentifiers=" + this.c + ", retryPolicyConfig=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public String getLocale() {
        String str;
        SdkEnvironment sdkEnvironment = this.b;
        return (sdkEnvironment == null || (str = (String) CollectionUtils.getFirstOrNull(sdkEnvironment.getLocales())) == null) ? "" : str;
    }
}
