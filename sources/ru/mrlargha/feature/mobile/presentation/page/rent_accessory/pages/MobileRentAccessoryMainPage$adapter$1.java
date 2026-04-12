package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.feature.mobile.presentation.MobilePHoneSendSubIds;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MobileRentAccessoryMainPage.kt */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* synthetic */ class MobileRentAccessoryMainPage$adapter$1 extends FunctionReferenceImpl implements Function3<MobilePHoneSendSubIds, String, Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MobileRentAccessoryMainPage$adapter$1(Object obj) {
        super(3, obj, MobileRentAccessoryMainPage.class, "sendEvent", "sendEvent(Lru/mrlargha/feature/mobile/presentation/MobilePHoneSendSubIds;Ljava/lang/String;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(MobilePHoneSendSubIds mobilePHoneSendSubIds, String str, Integer num) {
        invoke(mobilePHoneSendSubIds, str, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(MobilePHoneSendSubIds p0, String p1, int i) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((MobileRentAccessoryMainPage) this.receiver).sendEvent(p0, p1, i);
    }
}
