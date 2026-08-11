package ru.mrlargha.commonui.elements.authorization.presentation.screen;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.CountDownTimer;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.GravityCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.R;
/* compiled from: AuthorizationButtonCooldown.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/AuthorizationButtonCooldown;", "", "button", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "timer", "Landroid/os/CountDownTimer;", TtmlNode.START, "", "durationMillis", "", "onFinish", "Lkotlin/Function0;", "showEnabled", "showDisabled", "createProgressDrawable", "Landroid/graphics/drawable/ClipDrawable;", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AuthorizationButtonCooldown {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final long MAX_DRAWABLE_LEVEL = 10000;
    @Deprecated
    public static final long PROGRESS_TICK_MILLIS = 50;
    private final View button;
    private CountDownTimer timer;

    public AuthorizationButtonCooldown(View button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.button = button;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [ru.mrlargha.commonui.elements.authorization.presentation.screen.AuthorizationButtonCooldown$start$1] */
    public final void start(final long j, final Function0<Unit> onFinish) {
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        if (j <= 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        final ClipDrawable createProgressDrawable = createProgressDrawable();
        this.timer = new CountDownTimer(j, createProgressDrawable, this, onFinish) { // from class: ru.mrlargha.commonui.elements.authorization.presentation.screen.AuthorizationButtonCooldown$start$1
            final /* synthetic */ long $durationMillis;
            final /* synthetic */ Function0<Unit> $onFinish;
            final /* synthetic */ ClipDrawable $progressDrawable;
            final /* synthetic */ AuthorizationButtonCooldown this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(j, 50L);
                this.$durationMillis = j;
                this.$progressDrawable = createProgressDrawable;
                this.this$0 = this;
                this.$onFinish = onFinish;
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                long j3 = this.$durationMillis;
                long coerceIn = RangesKt.coerceIn(j3 - j2, 0L, j3);
                ClipDrawable clipDrawable = this.$progressDrawable;
                if (clipDrawable != null) {
                    clipDrawable.setLevel((int) ((coerceIn * 10000) / this.$durationMillis));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                View view;
                this.this$0.timer = null;
                view = this.this$0.button;
                view.setBackgroundResource(R.drawable.authorization_border_red);
                this.$onFinish.invoke();
            }
        }.start();
    }

    public final void showEnabled() {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
        this.button.setBackgroundResource(R.drawable.authorization_border_red);
    }

    public final void showDisabled() {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
        this.button.setBackgroundResource(R.drawable.authorization_border);
    }

    private final ClipDrawable createProgressDrawable() {
        Drawable drawable = AppCompatResources.getDrawable(this.button.getContext(), R.drawable.authorization_border);
        Drawable mutate = drawable != null ? drawable.mutate() : null;
        Drawable drawable2 = AppCompatResources.getDrawable(this.button.getContext(), R.drawable.authorization_border_red);
        Drawable mutate2 = drawable2 != null ? drawable2.mutate() : null;
        if (mutate == null || mutate2 == null) {
            this.button.setBackgroundResource(R.drawable.authorization_border);
            return null;
        }
        ClipDrawable clipDrawable = new ClipDrawable(mutate2, GravityCompat.START, 1);
        clipDrawable.setLevel(0);
        this.button.setBackground(new LayerDrawable(new Drawable[]{mutate, clipDrawable}));
        return clipDrawable;
    }

    /* compiled from: AuthorizationButtonCooldown.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/presentation/screen/AuthorizationButtonCooldown$Companion;", "", "<init>", "()V", "MAX_DRAWABLE_LEVEL", "", "PROGRESS_TICK_MILLIS", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
