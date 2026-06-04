package ru.mrlargha.commonui.elements.test;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.core.SAMPUIElement;
import ru.mrlargha.commonui.core.UIElementAbstractSpawner;
import ru.mrlargha.commonui.core.UIElementID;
import ru.mrlargha.commonui.databinding.TestTestScreenBinding;
import ru.mrlargha.commonui.utils.ui.money.MoneyElementKt;
/* compiled from: test.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/elements/test/TestScreen;", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "<init>", "(Landroid/app/Activity;I)V", "screen", "Landroid/view/View;", "kotlin.jvm.PlatformType", "binding", "Lru/mrlargha/commonui/databinding/TestTestScreenBinding;", "minValue", "", "maxValue", "value1", "setupListeners", "", "multiplyOrReset", "value", "divideOrReset", "render", "Spawner", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TestScreen extends SAMPUIElement {
    private final TestTestScreenBinding binding;
    private final long maxValue;
    private final long minValue;
    private final View screen;
    private long value1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestScreen(Activity targetActivity, int i) {
        super(targetActivity, i);
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        View screen = targetActivity.getLayoutInflater().inflate(R.layout.test_test_screen, (ViewGroup) null);
        this.screen = screen;
        TestTestScreenBinding bind = TestTestScreenBinding.bind(screen);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        this.binding = bind;
        this.minValue = 1L;
        this.maxValue = Long.MAX_VALUE;
        this.value1 = 1L;
        bind.etValue1123213e.setText("baadadd");
        Intrinsics.checkNotNullExpressionValue(screen, "screen");
        addViewToConstraintLayout(screen, -1, -1);
        Log.d(getCLASS_TAG(), "setupListeners: 1");
        setupListeners();
        Log.d(getCLASS_TAG(), "setupListeners: 2");
        render();
    }

    private final void setupListeners() {
        this.binding.btnPlusqqqqq.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.test.TestScreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestScreen.setupListeners$lambda$0(TestScreen.this, view);
            }
        });
        this.binding.btnMinus.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.test.TestScreen$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestScreen.setupListeners$lambda$1(TestScreen.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupListeners$lambda$0(TestScreen testScreen, View view) {
        Log.d(testScreen.getCLASS_TAG(), "setupListeners: +");
        testScreen.value1 = testScreen.multiplyOrReset(testScreen.value1);
        testScreen.render();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupListeners$lambda$1(TestScreen testScreen, View view) {
        Log.d(testScreen.getCLASS_TAG(), "setupListeners: ");
        testScreen.value1 = testScreen.divideOrReset(testScreen.value1);
        testScreen.render();
    }

    private final long multiplyOrReset(long j) {
        long j2 = j * 10;
        return j2 > this.maxValue ? this.minValue : j2;
    }

    private final long divideOrReset(long j) {
        long j2 = j / 10;
        return j2 < this.minValue ? this.maxValue : j2;
    }

    private final void render() {
        this.binding.etValue1123213e.setText(String.valueOf(this.value1));
        this.binding.etValue2.setText(MoneyElementKt.toMoneyFormattedSpannable$default(this.value1, false, null, null, null, 15, null));
        this.binding.etValue3.setText(MoneyElementKt.toMoneyShortFormattedSpannable(this.value1));
    }

    /* compiled from: test.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/test/TestScreen$Spawner;", "Lru/mrlargha/commonui/core/UIElementAbstractSpawner;", "<init>", "()V", "create", "Lru/mrlargha/commonui/core/SAMPUIElement;", "targetActivity", "Landroid/app/Activity;", "backendID", "", "correctIds", "", "Lru/mrlargha/commonui/core/UIElementID;", "getCorrectIds", "()Ljava/util/Set;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Spawner extends UIElementAbstractSpawner {
        private final Set<UIElementID> correctIds = SetsKt.setOf(UIElementID.TEST);

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public SAMPUIElement create(Activity targetActivity, int i) {
            Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
            return new TestScreen(targetActivity, i);
        }

        @Override // ru.mrlargha.commonui.core.UIElementAbstractSpawner
        public Set<UIElementID> getCorrectIds() {
            return this.correctIds;
        }
    }
}
