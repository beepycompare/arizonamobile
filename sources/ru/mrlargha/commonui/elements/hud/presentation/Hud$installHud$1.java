package ru.mrlargha.commonui.elements.hud.presentation;

import android.util.Log;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.databinding.HudPageBinding;
import ru.mrlargha.commonui.elements.hud.presentation.api.HudApi;
import ru.mrlargha.commonui.elements.hud.presentation.api.obj.HudApiRequest;
import ru.mrlargha.commonui.elements.hud.presentation.api.obj.Query;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hud.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.Hud$installHud$1", f = "Hud.kt", i = {4, 4}, l = {333, 334, 335, 336, 342}, m = "invokeSuspend", n = {"resp", SearchIntents.EXTRA_QUERY}, nl = {334, 335, 336, 337, 354}, s = {"L$0", "L$1"}, v = 2)
/* loaded from: classes6.dex */
public final class Hud$installHud$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $serverId;
    final /* synthetic */ int $serverType;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Hud this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Hud$installHud$1(int i, Hud hud, int i2, Continuation<? super Hud$installHud$1> continuation) {
        super(2, continuation);
        this.$serverType = i;
        this.this$0 = hud;
        this.$serverId = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Hud$installHud$1(this.$serverType, this.this$0, this.$serverId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Hud$installHud$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f6, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.commonui.elements.hud.presentation.Hud$installHud$1.AnonymousClass1(r4, r7.this$0, null), r7) == r0) goto L34;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HudApi hudApi;
        HudApi hudApi2;
        HudApi hudApi3;
        HudApi hudApi4;
        HudApiRequest hudApiRequest;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            Log.w("HUD", "error get server info", th);
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = this.$serverType;
            if (i2 == 0) {
                hudApi = this.this$0.api;
                this.label = 1;
                obj = hudApi.getArizonaMobileServerInfo(this);
                if (obj == coroutine_suspended) {
                }
                hudApiRequest = (HudApiRequest) obj;
            } else if (i2 == 1) {
                hudApi2 = this.this$0.api;
                this.label = 2;
                obj = hudApi2.getArizonaPcServerInfo(this);
                if (obj == coroutine_suspended) {
                }
                hudApiRequest = (HudApiRequest) obj;
            } else if (i2 == 2) {
                hudApi3 = this.this$0.api;
                this.label = 3;
                obj = hudApi3.getRodinaServerInfo(this);
                if (obj == coroutine_suspended) {
                }
                hudApiRequest = (HudApiRequest) obj;
            } else if (i2 == 3) {
                hudApi4 = this.this$0.api;
                this.label = 4;
                obj = hudApi4.getRodinaMobileServerInfo(this);
                if (obj == coroutine_suspended) {
                }
                hudApiRequest = (HudApiRequest) obj;
            } else {
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            hudApiRequest = (HudApiRequest) obj;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            hudApiRequest = (HudApiRequest) obj;
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            hudApiRequest = (HudApiRequest) obj;
        } else if (i != 4) {
            if (i == 5) {
                Query query = (Query) this.L$1;
                HudApiRequest hudApiRequest2 = (HudApiRequest) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            hudApiRequest = (HudApiRequest) obj;
        }
        int i3 = this.$serverId;
        Iterator<T> it = hudApiRequest.getQuery().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            Integer number = ((Query) obj2).getNumber();
            if (number != null && number.intValue() == i3) {
                break;
            }
        }
        Query query2 = (Query) obj2;
        if (query2 == null) {
            return Unit.INSTANCE;
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(hudApiRequest);
        this.L$1 = SpillingKt.nullOutSpilledVariable(query2);
        this.label = 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Hud.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.hud.presentation.Hud$installHud$1$1", f = "Hud.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.commonui.elements.hud.presentation.Hud$installHud$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Query $query;
        int label;
        final /* synthetic */ Hud this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Query query, Hud hud, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$query = query;
            this.this$0 = hud;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$query, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            HudPageBinding hudPageBinding;
            String str;
            HudPageBinding hudPageBinding2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String icon = this.$query.getIcon();
            if (icon != null) {
                this.this$0.installServerLogotype(icon);
            }
            hudPageBinding = this.this$0.binding;
            TextView textView = hudPageBinding.hudServerShieldName;
            boolean isArizonaType = ru.mrlargha.commonui.utils.UtilsKt.isArizonaType();
            Query query = this.$query;
            if (isArizonaType) {
                String name = query.getName();
                if (name != null) {
                    r3 = name.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(r3, "toUpperCase(...)");
                }
                str = r3 != null ? r3 : "";
            } else {
                String name2 = query.getName();
                r3 = name2 != null ? StringsKt.substringBefore$default(name2, " ", (String) null, 2, (Object) null) : null;
                str = r3 != null ? r3 : "";
            }
            textView.setText(str);
            hudPageBinding2 = this.this$0.binding;
            hudPageBinding2.hudServerInfoContainer.setVisibility(0);
            return Unit.INSTANCE;
        }
    }
}
