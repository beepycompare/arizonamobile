package com.arizonagames.feature.arizona.imageviewer;

import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: WelcomeBannersRepository.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0086@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannersRepository;", "", "api", "Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannersApi;", "projectResourceUrlProvider", "Lkotlin/Function0;", "", "<init>", "(Lcom/arizonagames/feature/arizona/imageviewer/WelcomeBannersApi;Lkotlin/jvm/functions/Function0;)V", "load", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "image-viewer"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WelcomeBannersRepository {
    private final WelcomeBannersApi api;
    private final Function0<String> projectResourceUrlProvider;

    public WelcomeBannersRepository(WelcomeBannersApi api, Function0<String> projectResourceUrlProvider) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(projectResourceUrlProvider, "projectResourceUrlProvider");
        this.api = api;
        this.projectResourceUrlProvider = projectResourceUrlProvider;
    }

    public /* synthetic */ WelcomeBannersRepository(WelcomeBannersApi welcomeBannersApi, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(welcomeBannersApi, (i & 2) != 0 ? new Function0() { // from class: com.arizonagames.feature.arizona.imageviewer.WelcomeBannersRepository$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String projectResourceUrl$default;
                projectResourceUrl$default = FirebaseConfigHelper.getProjectResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
                return projectResourceUrl$default;
            }
        } : function0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object load(Continuation<? super List<String>> continuation) {
        WelcomeBannersRepository$load$1 welcomeBannersRepository$load$1;
        int i;
        String str;
        String resolve;
        if (continuation instanceof WelcomeBannersRepository$load$1) {
            welcomeBannersRepository$load$1 = (WelcomeBannersRepository$load$1) continuation;
            if ((welcomeBannersRepository$load$1.label & Integer.MIN_VALUE) != 0) {
                welcomeBannersRepository$load$1.label -= Integer.MIN_VALUE;
                Object obj = welcomeBannersRepository$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = welcomeBannersRepository$load$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String invoke = this.projectResourceUrlProvider.invoke();
                    WelcomeBannersApi welcomeBannersApi = this.api;
                    welcomeBannersRepository$load$1.L$0 = invoke;
                    welcomeBannersRepository$load$1.label = 1;
                    Object welcomeBanners = welcomeBannersApi.getWelcomeBanners(welcomeBannersRepository$load$1);
                    if (welcomeBanners == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = welcomeBanners;
                    str = invoke;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    str = (String) welcomeBannersRepository$load$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                ArrayList arrayList = new ArrayList();
                for (WelcomeBannerDto welcomeBannerDto : (Iterable) obj) {
                    String imagePath = welcomeBannerDto.getImagePath();
                    String str2 = null;
                    if (imagePath != null) {
                        if (StringsKt.isBlank(imagePath)) {
                            imagePath = null;
                        }
                        if (imagePath != null && (resolve = WelcomeBannerUrlResolver.INSTANCE.resolve(imagePath, str)) != null) {
                            str2 = resolve;
                        }
                    }
                    if (str2 != null) {
                        arrayList.add(str2);
                    }
                }
                return arrayList;
            }
        }
        welcomeBannersRepository$load$1 = new WelcomeBannersRepository$load$1(this, continuation);
        Object obj2 = welcomeBannersRepository$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = welcomeBannersRepository$load$1.label;
        if (i != 0) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (r6.hasNext()) {
        }
        return arrayList2;
    }
}
