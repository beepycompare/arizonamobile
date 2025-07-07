package com.arkivanov.decompose.router.stack.webhistory;

import com.arkivanov.decompose.router.stack.ChildStack;
import com.arkivanov.decompose.router.stack.StackNavigator;
import com.arkivanov.decompose.router.stack.webhistory.WebHistoryController;
import com.arkivanov.decompose.value.Value;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
/* compiled from: WebHistoryController.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001JÒ\u0001\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0016\u0010\f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\t\u0012\u0002\b\u00030\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00040\u00122!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\t0\u00122D\b\u0002\u0010\u0018\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\t0\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001a\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u0002H\t0\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u0019H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/arkivanov/decompose/router/stack/webhistory/WebHistoryController;", "", "historyPaths", "", "", "getHistoryPaths", "()Ljava/util/List;", "attach", "", "C", "navigator", "Lcom/arkivanov/decompose/router/stack/StackNavigator;", "stack", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "serializer", "Lkotlinx/serialization/KSerializer;", "getPath", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "configuration", "getConfiguration", "path", "onWebNavigation", "Lkotlin/Function2;", "newStack", "oldStack", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface WebHistoryController {
    <C> void attach(StackNavigator<C> stackNavigator, Value<? extends ChildStack<? extends C, ?>> value, KSerializer<C> kSerializer, Function1<? super C, String> function1, Function1<? super String, ? extends C> function12, Function2<? super List<? extends C>, ? super List<? extends C>, Boolean> function2);

    List<String> getHistoryPaths();

    /* compiled from: WebHistoryController.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean attach$lambda$0(List list, List list2) {
            Intrinsics.checkNotNullParameter(list, "<unused var>");
            Intrinsics.checkNotNullParameter(list2, "<unused var>");
            return true;
        }

        public static /* synthetic */ void attach$default(WebHistoryController webHistoryController, StackNavigator stackNavigator, Value value, KSerializer kSerializer, Function1 function1, Function1 function12, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attach");
            }
            if ((i & 32) != 0) {
                function2 = new Function2() { // from class: com.arkivanov.decompose.router.stack.webhistory.WebHistoryController$DefaultImpls$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        boolean attach$lambda$0;
                        attach$lambda$0 = WebHistoryController.DefaultImpls.attach$lambda$0((List) obj2, (List) obj3);
                        return Boolean.valueOf(attach$lambda$0);
                    }
                };
            }
            webHistoryController.attach(stackNavigator, value, kSerializer, function1, function12, function2);
        }
    }
}
