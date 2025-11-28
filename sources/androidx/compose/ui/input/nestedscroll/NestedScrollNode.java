package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: NestedScrollNode.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00020-2\u0006\u0010#\u001a\u00020-H\u0096@¢\u0006\u0004\b.\u0010/J \u00100\u001a\u00020-2\u0006\u0010)\u001a\u00020-2\u0006\u0010#\u001a\u00020-H\u0096@¢\u0006\u0004\b1\u00102J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00106\u001a\u000204H\u0016J\b\u00107\u001a\u000204H\u0016J\b\u00108\u001a\u000204H\u0002J\b\u00109\u001a\u000204H\u0002J\u001f\u0010:\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b;R\u001a\u0010\u0004\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006<"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "<init>", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "resolvedDispatcher", "lastKnownParentNode", "getLastKnownParentNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setLastKnownParentNode$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "parentNestedScrollNode", "getParentNestedScrollNode$ui_release", "parentConnection", "getParentConnection", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope$annotations", "()V", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDispatcher", "", "newDispatcher", "onAttach", "onDetach", "updateDispatcherFields", "resetDispatcherFields", "updateNode", "updateNode$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    private static /* synthetic */ void getNestedCoroutineScope$annotations() {
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    public final NestedScrollNode getLastKnownParentNode$ui_release() {
        return this.lastKnownParentNode;
    }

    public final void setLastKnownParentNode$ui_release(NestedScrollNode nestedScrollNode) {
        this.lastKnownParentNode = nestedScrollNode;
    }

    public final NestedScrollNode getParentNestedScrollNode$ui_release() {
        if (isAttached()) {
            return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
        }
        return null;
    }

    private final NestedScrollConnection getParentConnection() {
        if (isAttached()) {
            return getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope nestedCoroutineScope;
        if (ComposeUiFlags.isNestedScrollDispatcherNodeFixEnabled) {
            NestedScrollNode parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
            CoroutineScope nestedCoroutineScope2 = parentNestedScrollNode$ui_release != null ? parentNestedScrollNode$ui_release.getNestedCoroutineScope() : null;
            if (nestedCoroutineScope2 == null || !CoroutineScopeKt.isActive(nestedCoroutineScope2)) {
                CoroutineScope scope$ui_release = this.resolvedDispatcher.getScope$ui_release();
                if (scope$ui_release != null) {
                    return scope$ui_release;
                }
                throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
            }
            return nestedCoroutineScope2;
        }
        NestedScrollNode parentNestedScrollNode$ui_release2 = getParentNestedScrollNode$ui_release();
        if (parentNestedScrollNode$ui_release2 == null || (nestedCoroutineScope = parentNestedScrollNode$ui_release2.getNestedCoroutineScope()) == null) {
            CoroutineScope scope$ui_release2 = this.resolvedDispatcher.getScope$ui_release();
            if (scope$ui_release2 != null) {
                return scope$ui_release2;
            }
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return nestedCoroutineScope;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo929onPreScrollOzD1aCk(long j, int i) {
        NestedScrollConnection parentConnection = getParentConnection();
        long mo929onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo929onPreScrollOzD1aCk(j, i) : Offset.Companion.m5052getZeroF1C5BW0();
        return Offset.m5041plusMKHz9U(mo929onPreScrollOzD1aCk, this.connection.mo929onPreScrollOzD1aCk(Offset.m5040minusMKHz9U(j, mo929onPreScrollOzD1aCk), i));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo578onPostScrollDzOQY0M(long j, long j2, int i) {
        long m5052getZeroF1C5BW0;
        long mo578onPostScrollDzOQY0M = this.connection.mo578onPostScrollDzOQY0M(j, j2, i);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            m5052getZeroF1C5BW0 = parentConnection.mo578onPostScrollDzOQY0M(Offset.m5041plusMKHz9U(j, mo578onPostScrollDzOQY0M), Offset.m5040minusMKHz9U(j2, mo578onPostScrollDzOQY0M), i);
        } else {
            m5052getZeroF1C5BW0 = Offset.Companion.m5052getZeroF1C5BW0();
        }
        return Offset.m5041plusMKHz9U(mo578onPostScrollDzOQY0M, m5052getZeroF1C5BW0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
        if (r11 == r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
        if (r11 == r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo928onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        int i;
        long m8245getZero9UxMQ8M;
        long j2;
        if (continuation instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) continuation;
            if ((nestedScrollNode$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label -= Integer.MIN_VALUE;
                Object obj = nestedScrollNode$onPreFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = nestedScrollNode$onPreFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection parentConnection = getParentConnection();
                    if (parentConnection != null) {
                        nestedScrollNode$onPreFling$1.J$0 = j;
                        nestedScrollNode$onPreFling$1.label = 1;
                        obj = parentConnection.mo928onPreFlingQWom1Mo(j, nestedScrollNode$onPreFling$1);
                    } else {
                        m8245getZero9UxMQ8M = Velocity.Companion.m8245getZero9UxMQ8M();
                        long j3 = m8245getZero9UxMQ8M;
                        long j4 = j;
                        j2 = j3;
                        NestedScrollConnection nestedScrollConnection = this.connection;
                        long m8237minusAH228Gc = Velocity.m8237minusAH228Gc(j4, j2);
                        nestedScrollNode$onPreFling$1.J$0 = j2;
                        nestedScrollNode$onPreFling$1.label = 2;
                        obj = nestedScrollConnection.mo928onPreFlingQWom1Mo(m8237minusAH228Gc, nestedScrollNode$onPreFling$1);
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        j2 = nestedScrollNode$onPreFling$1.J$0;
                        ResultKt.throwOnFailure(obj);
                        return Velocity.m8225boximpl(Velocity.m8238plusAH228Gc(j2, ((Velocity) obj).m8243unboximpl()));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j = nestedScrollNode$onPreFling$1.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                m8245getZero9UxMQ8M = ((Velocity) obj).m8243unboximpl();
                long j32 = m8245getZero9UxMQ8M;
                long j42 = j;
                j2 = j32;
                NestedScrollConnection nestedScrollConnection2 = this.connection;
                long m8237minusAH228Gc2 = Velocity.m8237minusAH228Gc(j42, j2);
                nestedScrollNode$onPreFling$1.J$0 = j2;
                nestedScrollNode$onPreFling$1.label = 2;
                obj = nestedScrollConnection2.mo928onPreFlingQWom1Mo(m8237minusAH228Gc2, nestedScrollNode$onPreFling$1);
            }
        }
        nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
        Object obj2 = nestedScrollNode$onPreFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nestedScrollNode$onPreFling$1.label;
        if (i != 0) {
        }
        m8245getZero9UxMQ8M = ((Velocity) obj2).m8243unboximpl();
        long j322 = m8245getZero9UxMQ8M;
        long j422 = j;
        j2 = j322;
        NestedScrollConnection nestedScrollConnection22 = this.connection;
        long m8237minusAH228Gc22 = Velocity.m8237minusAH228Gc(j422, j2);
        nestedScrollNode$onPreFling$1.J$0 = j2;
        nestedScrollNode$onPreFling$1.label = 2;
        obj2 = nestedScrollConnection22.mo928onPreFlingQWom1Mo(m8237minusAH228Gc22, nestedScrollNode$onPreFling$1);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo577onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        int i;
        long j3;
        long j4;
        long m8243unboximpl;
        NestedScrollConnection parentConnection;
        long m8245getZero9UxMQ8M;
        long j5;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            if ((nestedScrollNode$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label -= Integer.MIN_VALUE;
                NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$12 = nestedScrollNode$onPostFling$1;
                Object obj = nestedScrollNode$onPostFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = nestedScrollNode$onPostFling$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection nestedScrollConnection = this.connection;
                    nestedScrollNode$onPostFling$12.J$0 = j;
                    nestedScrollNode$onPostFling$12.J$1 = j2;
                    nestedScrollNode$onPostFling$12.label = 1;
                    obj = nestedScrollConnection.mo577onPostFlingRZ2iAVY(j, j2, nestedScrollNode$onPostFling$12);
                    if (obj != coroutine_suspended) {
                        j3 = j;
                        j4 = j2;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        j5 = nestedScrollNode$onPostFling$12.J$0;
                        ResultKt.throwOnFailure(obj);
                        m8245getZero9UxMQ8M = ((Velocity) obj).m8243unboximpl();
                        m8243unboximpl = j5;
                        return Velocity.m8225boximpl(Velocity.m8238plusAH228Gc(m8243unboximpl, m8245getZero9UxMQ8M));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j4 = nestedScrollNode$onPostFling$12.J$1;
                    j3 = nestedScrollNode$onPostFling$12.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                m8243unboximpl = ((Velocity) obj).m8243unboximpl();
                parentConnection = !isAttached() ? getParentConnection() : this.lastKnownParentNode;
                if (parentConnection == null) {
                    long m8238plusAH228Gc = Velocity.m8238plusAH228Gc(j3, m8243unboximpl);
                    long m8237minusAH228Gc = Velocity.m8237minusAH228Gc(j4, m8243unboximpl);
                    nestedScrollNode$onPostFling$12.J$0 = m8243unboximpl;
                    nestedScrollNode$onPostFling$12.label = 2;
                    obj = parentConnection.mo577onPostFlingRZ2iAVY(m8238plusAH228Gc, m8237minusAH228Gc, nestedScrollNode$onPostFling$12);
                    if (obj != coroutine_suspended) {
                        j5 = m8243unboximpl;
                        m8245getZero9UxMQ8M = ((Velocity) obj).m8243unboximpl();
                        m8243unboximpl = j5;
                        return Velocity.m8225boximpl(Velocity.m8238plusAH228Gc(m8243unboximpl, m8245getZero9UxMQ8M));
                    }
                    return coroutine_suspended;
                }
                m8245getZero9UxMQ8M = Velocity.Companion.m8245getZero9UxMQ8M();
                return Velocity.m8225boximpl(Velocity.m8238plusAH228Gc(m8243unboximpl, m8245getZero9UxMQ8M));
            }
        }
        nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$122 = nestedScrollNode$onPostFling$1;
        Object obj2 = nestedScrollNode$onPostFling$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nestedScrollNode$onPostFling$122.label;
        if (i != 0) {
        }
        m8243unboximpl = ((Velocity) obj2).m8243unboximpl();
        parentConnection = !isAttached() ? getParentConnection() : this.lastKnownParentNode;
        if (parentConnection == null) {
        }
    }

    private final void updateDispatcher(NestedScrollDispatcher nestedScrollDispatcher) {
        resetDispatcherFields();
        if (nestedScrollDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(nestedScrollDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = nestedScrollDispatcher;
        }
        if (isAttached()) {
            updateDispatcherFields();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        NestedScrollNode nestedScrollNode = (NestedScrollNode) NestedScrollNodeKt.access$findNearestAttachedAncestor(this);
        this.lastKnownParentNode = nestedScrollNode;
        this.resolvedDispatcher.setLastKnownParentNode$ui_release(nestedScrollNode);
        resetDispatcherFields();
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        this.resolvedDispatcher.setLastKnownParentNode$ui_release(null);
        this.lastKnownParentNode = null;
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode$updateDispatcherFields$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                CoroutineScope nestedCoroutineScope;
                nestedCoroutineScope = NestedScrollNode.this.getNestedCoroutineScope();
                return nestedCoroutineScope;
            }
        });
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode$ui_release() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui_release(null);
        }
    }

    public final void updateNode$ui_release(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        updateDispatcher(nestedScrollDispatcher);
    }
}
