package ru.mrlargha.feature.selector.presentation;

import kotlin.Metadata;
/* compiled from: Test.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/feature/selector/presentation/Test;", "", "<init>", "()V", "selectorData", "", "getSelectorData", "()Ljava/lang/String;", "selector"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Test {
    public static final Test INSTANCE = new Test();
    private static final String selectorData = "{\"currentIndex\":0,\"maxIndex\":5,\"title\":\"АППАРТАМЕНЫ ЛЮКС\",\"price\":500000,\"currencyType\":0,\"declineButton\":{\"name\":\"ОТКЛОНИТЬ\",\"style\":0},\"confirmButton\":{\"name\":\"КУПИТЬ\",\"style\":1},\"additionalInfo\":[{\"title\":\"Название:\",\"value\":\"MP-5\"},{\"title\":\"Патроны:\",\"value\":\"100\"},{\"title\":\"Стоимость:\",\"value\":\"200 000 000 $\"}]}";

    private Test() {
    }

    public final String getSelectorData() {
        return selectorData;
    }
}
