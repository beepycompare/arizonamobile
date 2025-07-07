package com.arizona.launcher.di;

import com.arizona.launcher.data.repository.SecondaryUpdateApi;
import com.arizona.launcher.data.repository.UpdateApi;
import com.arizona.launcher.util.FlavorUtilKt;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/* compiled from: UpdateApiModule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/di/UpdateApiModule;", "", "<init>", "()V", "getRetrofit", "Lretrofit2/Retrofit;", "url", "", "provideApi", "Lcom/arizona/launcher/data/repository/UpdateApi;", "provideSecondaryApi", "Lcom/arizona/launcher/data/repository/SecondaryUpdateApi;", "Companion", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
/* loaded from: classes3.dex */
public final class UpdateApiModule {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String SERVER_MAIN_URl_ARIZONA = "https://mob.maz-ins.com/game/release/";
    private static final String SERVER_MAIN_URl_RODINA = "https://mob.maz-ins.com/game/release/";
    private static final String SERVER_SECONDARY_URL_ARIZONA = "https://arz-mob.react-group.tech/game/release/";
    private static final String SERVER_SECONDARY_URL_RODINA = "https://arz-mob.react-group.tech/game/release/";

    private final Retrofit getRetrofit(String str) {
        Retrofit build = new Retrofit.Builder().baseUrl(str).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    @Provides
    public final UpdateApi provideApi() {
        if (FlavorUtilKt.isArizona()) {
            Object create = getRetrofit("https://mob.maz-ins.com/game/release/").create(UpdateApi.class);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return (UpdateApi) create;
        }
        Object create2 = getRetrofit("https://mob.maz-ins.com/game/release/").create(UpdateApi.class);
        Intrinsics.checkNotNullExpressionValue(create2, "create(...)");
        return (UpdateApi) create2;
    }

    @Provides
    public final SecondaryUpdateApi provideSecondaryApi() {
        if (FlavorUtilKt.isArizona()) {
            Object create = getRetrofit("https://arz-mob.react-group.tech/game/release/").create(SecondaryUpdateApi.class);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return (SecondaryUpdateApi) create;
        }
        Object create2 = getRetrofit("https://arz-mob.react-group.tech/game/release/").create(SecondaryUpdateApi.class);
        Intrinsics.checkNotNullExpressionValue(create2, "create(...)");
        return (SecondaryUpdateApi) create2;
    }

    /* compiled from: UpdateApiModule.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/di/UpdateApiModule$Companion;", "", "<init>", "()V", "SERVER_MAIN_URl_ARIZONA", "", "SERVER_SECONDARY_URL_ARIZONA", "SERVER_MAIN_URl_RODINA", "SERVER_SECONDARY_URL_RODINA", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
