package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1", f = "TextFieldSelectionManager.kt", i = {0, 0}, l = {781}, m = "invokeSuspend", n = {"copy", "cut"}, s = {"L$0", "L$1"})
/* loaded from: classes.dex */
public final class TextFieldSelectionManager$showSelectionToolbar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager$showSelectionToolbar$1(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super TextFieldSelectionManager$showSelectionToolbar$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldSelectionManager$showSelectionToolbar$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldSelectionManager$showSelectionToolbar$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        LegacyTextFieldState state$foundation_release;
        Function0<Unit> function0;
        Function0<Unit> function02;
        Function0<Unit> function03;
        Function0<Unit> function04;
        Function0<Unit> function05;
        TextToolbar textToolbar;
        Rect contentRect;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = false;
        Function0<Unit> function06 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.getEnabled() || ((state$foundation_release = this.this$0.getState$foundation_release()) != null && !state$foundation_release.isInTouchMode())) {
                return Unit.INSTANCE;
            }
            boolean z2 = this.this$0.getVisualTransformation$foundation_release() instanceof PasswordVisualTransformation;
            if (TextRange.m6141getCollapsedimpl(this.this$0.getValue$foundation_release().m6396getSelectiond9O1mEE()) || z2) {
                function0 = null;
            } else {
                final TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$copy$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TextFieldSelectionManager.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$copy$1$1", f = "TextFieldSelectionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$copy$1$1  reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ TextFieldSelectionManager this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = textFieldSelectionManager;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                TextFieldSelectionManager.copy$foundation_release$default(this.this$0, false, 1, null);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        CoroutineScope coroutineScope$foundation_release = TextFieldSelectionManager.this.getCoroutineScope$foundation_release();
                        if (coroutineScope$foundation_release != null) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope$foundation_release, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(TextFieldSelectionManager.this, null), 1, null);
                        }
                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    }
                };
            }
            if (TextRange.m6141getCollapsedimpl(this.this$0.getValue$foundation_release().m6396getSelectiond9O1mEE()) || !this.this$0.getEditable() || z2) {
                function02 = null;
            } else {
                final TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$cut$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: TextFieldSelectionManager.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$cut$1$1", f = "TextFieldSelectionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$cut$1$1  reason: invalid class name */
                    /* loaded from: classes.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ TextFieldSelectionManager this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = textFieldSelectionManager;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.this$0.cut$foundation_release();
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        CoroutineScope coroutineScope$foundation_release = TextFieldSelectionManager.this.getCoroutineScope$foundation_release();
                        if (coroutineScope$foundation_release != null) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope$foundation_release, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(TextFieldSelectionManager.this, null), 1, null);
                        }
                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    }
                };
            }
            if (this.this$0.getEditable()) {
                Clipboard clipboard$foundation_release = this.this$0.getClipboard$foundation_release();
                if (clipboard$foundation_release != null) {
                    this.L$0 = function0;
                    this.L$1 = function02;
                    this.label = 1;
                    Object clipEntry = clipboard$foundation_release.getClipEntry(this);
                    if (clipEntry == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function03 = function02;
                    obj = clipEntry;
                }
                if (z) {
                    final TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
                    function04 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$paste$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: TextFieldSelectionManager.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$paste$1$1", f = "TextFieldSelectionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$paste$1$1  reason: invalid class name */
                        /* loaded from: classes.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            int label;
                            final /* synthetic */ TextFieldSelectionManager this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.this$0 = textFieldSelectionManager;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.this$0, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.this$0.paste$foundation_release();
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            CoroutineScope coroutineScope$foundation_release = TextFieldSelectionManager.this.getCoroutineScope$foundation_release();
                            if (coroutineScope$foundation_release != null) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope$foundation_release, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(TextFieldSelectionManager.this, null), 1, null);
                            }
                            TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                        }
                    };
                    Function0<Unit> function07 = function02;
                    Function0<Unit> function08 = function0;
                    if (TextRange.m6143getLengthimpl(this.this$0.getValue$foundation_release().m6396getSelectiond9O1mEE()) != this.this$0.getValue$foundation_release().getText().length()) {
                        final TextFieldSelectionManager textFieldSelectionManager4 = this.this$0;
                        function05 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$selectAll$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                TextFieldSelectionManager.this.selectAll$foundation_release();
                            }
                        };
                    } else {
                        function05 = null;
                    }
                    if (this.this$0.getEditable() && TextRange.m6141getCollapsedimpl(this.this$0.getValue$foundation_release().m6396getSelectiond9O1mEE())) {
                        final TextFieldSelectionManager textFieldSelectionManager5 = this.this$0;
                        function06 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$autofill$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                TextFieldSelectionManager.this.autofill$foundation_release();
                            }
                        };
                    }
                    Function0<Unit> function09 = function06;
                    textToolbar = this.this$0.getTextToolbar();
                    if (textToolbar != null) {
                        contentRect = this.this$0.getContentRect();
                        textToolbar.showMenu(contentRect, function08, function04, function07, function05, function09);
                    }
                    return Unit.INSTANCE;
                }
            }
            function04 = null;
            Function0<Unit> function072 = function02;
            Function0<Unit> function082 = function0;
            if (TextRange.m6143getLengthimpl(this.this$0.getValue$foundation_release().m6396getSelectiond9O1mEE()) != this.this$0.getValue$foundation_release().getText().length()) {
            }
            if (this.this$0.getEditable()) {
                final TextFieldSelectionManager textFieldSelectionManager52 = this.this$0;
                function06 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$1$autofill$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TextFieldSelectionManager.this.autofill$foundation_release();
                    }
                };
            }
            Function0<Unit> function092 = function06;
            textToolbar = this.this$0.getTextToolbar();
            if (textToolbar != null) {
            }
            return Unit.INSTANCE;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            function03 = (Function0) this.L$1;
            function0 = (Function0) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ClipEntry clipEntry2 = (ClipEntry) obj;
        if (clipEntry2 == null || !ClipboardUtils_androidKt.hasText(clipEntry2)) {
            function02 = function03;
        } else {
            function02 = function03;
            z = true;
        }
        if (z) {
        }
        function04 = null;
        Function0<Unit> function0722 = function02;
        Function0<Unit> function0822 = function0;
        if (TextRange.m6143getLengthimpl(this.this$0.getValue$foundation_release().m6396getSelectiond9O1mEE()) != this.this$0.getValue$foundation_release().getText().length()) {
        }
        if (this.this$0.getEditable()) {
        }
        Function0<Unit> function0922 = function06;
        textToolbar = this.this$0.getTextToolbar();
        if (textToolbar != null) {
        }
        return Unit.INSTANCE;
    }
}
