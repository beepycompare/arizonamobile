package androidx.paging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Separators.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u0002H\u00012\u00020\u0002B]\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012L\u0010\u0006\u001aH\b\u0001\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00010<H\u0086@¢\u0006\u0002\u0010>J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000@*\b\u0012\u0004\u0012\u00028\u00010@J\"\u0010A\u001a\u00020\u001a\"\b\b\u0002\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00030@2\u0006\u0010\u0004\u001a\u00020\u0005J\"\u0010B\u001a\u00020\u001a\"\b\b\u0002\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00030@2\u0006\u0010\u0004\u001a\u00020\u0005J\"\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000@2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00010@H\u0086@¢\u0006\u0002\u0010DJ\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000F2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00010FJ\"\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00010HH\u0086@¢\u0006\u0002\u0010IJ\"\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00010KH\u0086@¢\u0006\u0002\u0010LJ&\u0010M\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0016\"\b\b\u0002\u0010\u0003*\u00020\u00022\f\u0010N\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0016H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010RY\u0010\u0006\u001aH\b\u0001\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001a\u00105\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR\u001a\u00108\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001c\"\u0004\b:\u0010\u001e¨\u0006O"}, d2 = {"Landroidx/paging/SeparatorState;", "R", "", ExifInterface.GPS_DIRECTION_TRUE, "terminalSeparatorType", "Landroidx/paging/TerminalSeparatorType;", "generator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", TtmlNode.ANNOTATION_POSITION_BEFORE, TtmlNode.ANNOTATION_POSITION_AFTER, "Lkotlin/coroutines/Continuation;", "<init>", "(Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)V", "getTerminalSeparatorType", "()Landroidx/paging/TerminalSeparatorType;", "getGenerator", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "pageStash", "", "Landroidx/paging/TransformablePage;", "getPageStash", "()Ljava/util/List;", "endTerminalSeparatorDeferred", "", "getEndTerminalSeparatorDeferred", "()Z", "setEndTerminalSeparatorDeferred", "(Z)V", "startTerminalSeparatorDeferred", "getStartTerminalSeparatorDeferred", "setStartTerminalSeparatorDeferred", "sourceStates", "Landroidx/paging/MutableLoadStateCollection;", "getSourceStates", "()Landroidx/paging/MutableLoadStateCollection;", "mediatorStates", "Landroidx/paging/LoadStates;", "getMediatorStates", "()Landroidx/paging/LoadStates;", "setMediatorStates", "(Landroidx/paging/LoadStates;)V", "placeholdersBefore", "", "getPlaceholdersBefore", "()I", "setPlaceholdersBefore", "(I)V", "placeholdersAfter", "getPlaceholdersAfter", "setPlaceholdersAfter", "footerAdded", "getFooterAdded", "setFooterAdded", "headerAdded", "getHeaderAdded", "setHeaderAdded", "onEvent", "Landroidx/paging/PageEvent;", NotificationCompat.CATEGORY_EVENT, "(Landroidx/paging/PageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asRType", "Landroidx/paging/PageEvent$Insert;", "terminatesStart", "terminatesEnd", "onInsert", "(Landroidx/paging/PageEvent$Insert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDrop", "Landroidx/paging/PageEvent$Drop;", "onLoadStateUpdate", "Landroidx/paging/PageEvent$LoadStateUpdate;", "(Landroidx/paging/PageEvent$LoadStateUpdate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStaticList", "Landroidx/paging/PageEvent$StaticList;", "(Landroidx/paging/PageEvent$StaticList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformablePageToStash", "originalPage", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SeparatorState<R, T extends R> {
    private boolean endTerminalSeparatorDeferred;
    private boolean footerAdded;
    private final Function3<T, T, Continuation<? super R>, Object> generator;
    private boolean headerAdded;
    private LoadStates mediatorStates;
    private final List<TransformablePage<T>> pageStash;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private final MutableLoadStateCollection sourceStates;
    private boolean startTerminalSeparatorDeferred;
    private final TerminalSeparatorType terminalSeparatorType;

    /* compiled from: Separators.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TerminalSeparatorType.values().length];
            try {
                iArr[TerminalSeparatorType.FULLY_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TerminalSeparatorType.SOURCE_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Insert<R> asRType(PageEvent.Insert<T> insert) {
        Intrinsics.checkNotNullParameter(insert, "<this>");
        return insert;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SeparatorState(TerminalSeparatorType terminalSeparatorType, Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> generator) {
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(generator, "generator");
        this.terminalSeparatorType = terminalSeparatorType;
        this.generator = generator;
        this.pageStash = new ArrayList();
        this.sourceStates = new MutableLoadStateCollection();
    }

    public final TerminalSeparatorType getTerminalSeparatorType() {
        return this.terminalSeparatorType;
    }

    public final Function3<T, T, Continuation<? super R>, Object> getGenerator() {
        return this.generator;
    }

    public final List<TransformablePage<T>> getPageStash() {
        return this.pageStash;
    }

    public final boolean getEndTerminalSeparatorDeferred() {
        return this.endTerminalSeparatorDeferred;
    }

    public final void setEndTerminalSeparatorDeferred(boolean z) {
        this.endTerminalSeparatorDeferred = z;
    }

    public final boolean getStartTerminalSeparatorDeferred() {
        return this.startTerminalSeparatorDeferred;
    }

    public final void setStartTerminalSeparatorDeferred(boolean z) {
        this.startTerminalSeparatorDeferred = z;
    }

    public final MutableLoadStateCollection getSourceStates() {
        return this.sourceStates;
    }

    public final LoadStates getMediatorStates() {
        return this.mediatorStates;
    }

    public final void setMediatorStates(LoadStates loadStates) {
        this.mediatorStates = loadStates;
    }

    public final int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public final void setPlaceholdersBefore(int i) {
        this.placeholdersBefore = i;
    }

    public final int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public final void setPlaceholdersAfter(int i) {
        this.placeholdersAfter = i;
    }

    public final boolean getFooterAdded() {
        return this.footerAdded;
    }

    public final void setFooterAdded(boolean z) {
        this.footerAdded = z;
    }

    public final boolean getHeaderAdded() {
        return this.headerAdded;
    }

    public final void setHeaderAdded(boolean z) {
        this.headerAdded = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r8 == r1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
        if (r8 == r1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
        if (r8 == r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onEvent(PageEvent<T> pageEvent, Continuation<? super PageEvent<R>> continuation) {
        SeparatorState$onEvent$1 separatorState$onEvent$1;
        int i;
        PageEvent.Drop<R> onDrop;
        if (continuation instanceof SeparatorState$onEvent$1) {
            separatorState$onEvent$1 = (SeparatorState$onEvent$1) continuation;
            if ((separatorState$onEvent$1.label & Integer.MIN_VALUE) != 0) {
                separatorState$onEvent$1.label -= Integer.MIN_VALUE;
                Object obj = separatorState$onEvent$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = separatorState$onEvent$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (pageEvent instanceof PageEvent.Insert) {
                        separatorState$onEvent$1.label = 1;
                        obj = onInsert((PageEvent.Insert) pageEvent, separatorState$onEvent$1);
                    } else if (pageEvent instanceof PageEvent.Drop) {
                        onDrop = onDrop((PageEvent.Drop) pageEvent);
                    } else if (pageEvent instanceof PageEvent.LoadStateUpdate) {
                        separatorState$onEvent$1.label = 2;
                        obj = onLoadStateUpdate((PageEvent.LoadStateUpdate) pageEvent, separatorState$onEvent$1);
                    } else if (!(pageEvent instanceof PageEvent.StaticList)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        separatorState$onEvent$1.label = 3;
                        obj = onStaticList((PageEvent.StaticList) pageEvent, separatorState$onEvent$1);
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    onDrop = (PageEvent) obj;
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    onDrop = (PageEvent) obj;
                } else if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                    onDrop = (PageEvent) obj;
                }
                if (this.endTerminalSeparatorDeferred || this.pageStash.isEmpty()) {
                    if (this.startTerminalSeparatorDeferred || this.pageStash.isEmpty()) {
                        return onDrop;
                    }
                    throw new IllegalStateException("deferred startTerm, page stash should be empty".toString());
                }
                throw new IllegalStateException("deferred endTerm, page stash should be empty".toString());
            }
        }
        separatorState$onEvent$1 = new SeparatorState$onEvent$1(this, continuation);
        Object obj2 = separatorState$onEvent$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = separatorState$onEvent$1.label;
        if (i != 0) {
        }
        if (this.endTerminalSeparatorDeferred) {
        }
        if (this.startTerminalSeparatorDeferred) {
        }
        return onDrop;
    }

    public final <T> boolean terminatesStart(PageEvent.Insert<T> insert, TerminalSeparatorType terminalSeparatorType) {
        LoadState prepend;
        Intrinsics.checkNotNullParameter(insert, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        if (insert.getLoadType() == LoadType.APPEND) {
            return this.startTerminalSeparatorDeferred;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[terminalSeparatorType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return insert.getSourceLoadStates().getPrepend().getEndOfPaginationReached();
        } else if (insert.getSourceLoadStates().getPrepend().getEndOfPaginationReached()) {
            LoadStates mediatorLoadStates = insert.getMediatorLoadStates();
            return mediatorLoadStates == null || (prepend = mediatorLoadStates.getPrepend()) == null || prepend.getEndOfPaginationReached();
        } else {
            return false;
        }
    }

    public final <T> boolean terminatesEnd(PageEvent.Insert<T> insert, TerminalSeparatorType terminalSeparatorType) {
        LoadState append;
        Intrinsics.checkNotNullParameter(insert, "<this>");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        if (insert.getLoadType() == LoadType.PREPEND) {
            return this.endTerminalSeparatorDeferred;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[terminalSeparatorType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return insert.getSourceLoadStates().getAppend().getEndOfPaginationReached();
        } else if (insert.getSourceLoadStates().getAppend().getEndOfPaginationReached()) {
            LoadStates mediatorLoadStates = insert.getMediatorLoadStates();
            return mediatorLoadStates == null || (append = mediatorLoadStates.getAppend()) == null || append.getEndOfPaginationReached();
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:202:0x0693, code lost:
        if (r2 == r4) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x029d, code lost:
        if (r2 == r4) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x070e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0714  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0735  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x076d  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0786  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0267  */
    /* JADX WARN: Type inference failed for: r1v76, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x0436 -> B:138:0x043c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:191:0x0629 -> B:192:0x062a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:217:0x070e -> B:218:0x070f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onInsert(PageEvent.Insert<T> insert, Continuation<? super PageEvent.Insert<R>> continuation) {
        SeparatorState$onInsert$1 separatorState$onInsert$1;
        boolean terminatesEnd;
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        TransformablePage<T> transformablePage;
        Integer num;
        TransformablePage<T> transformablePage2;
        Integer num2;
        PageEvent.Insert<T> insert2;
        TransformablePage<T> transformablePage3;
        int i2;
        TransformablePage<T> transformablePage4;
        ArrayList arrayList3;
        Object obj;
        Integer num3;
        TransformablePage<T> transformablePage5;
        boolean z;
        ArrayList arrayList4;
        Integer num4;
        boolean z2;
        boolean z3;
        int intValue;
        Integer num5;
        Integer num6;
        boolean z4;
        TransformablePage<T> transformablePage6;
        int i3;
        Integer num7;
        int i4;
        TransformablePage<T> transformablePage7;
        ArrayList arrayList5;
        ArrayList arrayList6;
        PageEvent.Insert<T> insert3;
        Object obj2;
        TransformablePage transformablePage8;
        Integer num8;
        boolean z5;
        ArrayList arrayList7;
        TransformablePage<T> transformablePage9;
        TransformablePage<T> transformablePage10;
        ArrayList arrayList8;
        Integer num9;
        ArrayList arrayList9;
        Iterator it;
        TransformablePage next;
        Integer num10;
        TransformablePage<T> transformablePage11;
        Iterator it2;
        TransformablePage transformablePage12;
        TransformablePage<T> transformablePage13;
        ArrayList arrayList10;
        TransformablePage<T> transformablePage14;
        Integer num11;
        Iterator it3;
        TransformablePage<T> transformablePage15;
        TransformablePage transformablePage16;
        ArrayList arrayList11;
        PageEvent.Insert<T> insert4;
        ArrayList arrayList12;
        PageEvent.Insert<T> insert5;
        int hintOriginalPageOffset;
        int i5;
        int intValue2;
        TransformablePage transformablePage17;
        SeparatorState$onInsert$1 separatorState$onInsert$12;
        PageEvent.Insert<T> insert6;
        int intValue3;
        int lastIndex;
        boolean z6;
        ArrayList arrayList13;
        PageEvent.Insert<T> insert7;
        int i6;
        int i7;
        ArrayList arrayList14;
        TransformablePage<T> transformablePage18;
        int i8;
        TransformablePage<T> transformablePage19;
        Object invoke;
        Object obj3;
        TransformablePage<T> transformablePage20;
        ArrayList arrayList15;
        ArrayList arrayList16;
        ArrayList arrayList17;
        LoadType loadType;
        LoadType loadType2;
        PageEvent.Insert<T> insert8 = insert;
        if (continuation instanceof SeparatorState$onInsert$1) {
            separatorState$onInsert$1 = (SeparatorState$onInsert$1) continuation;
            if ((separatorState$onInsert$1.label & Integer.MIN_VALUE) != 0) {
                separatorState$onInsert$1.label -= Integer.MIN_VALUE;
                Object obj4 = separatorState$onInsert$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (separatorState$onInsert$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj4);
                        boolean terminatesStart = terminatesStart(insert8, this.terminalSeparatorType);
                        terminatesEnd = terminatesEnd(insert8, this.terminalSeparatorType);
                        List<TransformablePage<T>> pages = insert8.getPages();
                        if (!(pages instanceof Collection) || !pages.isEmpty()) {
                            Iterator it4 = pages.iterator();
                            while (it4.hasNext()) {
                                if (!((TransformablePage) it4.next()).getData().isEmpty()) {
                                    i = 0;
                                    if (!this.headerAdded && insert8.getLoadType() == LoadType.PREPEND && i == 0) {
                                        throw new IllegalArgumentException("Additional prepend event after prepend state is done".toString());
                                    }
                                    if (!this.footerAdded && insert8.getLoadType() == LoadType.APPEND && i == 0) {
                                        throw new IllegalArgumentException("Additional append event after append state is done".toString());
                                    }
                                    this.sourceStates.set(insert8.getSourceLoadStates());
                                    this.mediatorStates = insert8.getMediatorLoadStates();
                                    if (insert8.getLoadType() != LoadType.APPEND) {
                                        this.placeholdersBefore = insert8.getPlaceholdersBefore();
                                    }
                                    if (insert8.getLoadType() != LoadType.PREPEND) {
                                        this.placeholdersAfter = insert8.getPlaceholdersAfter();
                                    }
                                    if (i != 0) {
                                        if (!terminatesStart && !terminatesEnd) {
                                            return asRType(insert);
                                        }
                                        if (this.headerAdded && this.footerAdded) {
                                            return asRType(insert);
                                        }
                                        if (this.pageStash.isEmpty()) {
                                            if (terminatesStart && terminatesEnd && !this.headerAdded && !this.footerAdded) {
                                                Function3<T, T, Continuation<? super R>, Object> function3 = this.generator;
                                                separatorState$onInsert$1.L$0 = insert8;
                                                z3 = true;
                                                separatorState$onInsert$1.label = 1;
                                                obj4 = function3.invoke(null, null, separatorState$onInsert$1);
                                                break;
                                            } else {
                                                if (!terminatesEnd || this.footerAdded) {
                                                    z2 = true;
                                                } else {
                                                    z2 = true;
                                                    this.endTerminalSeparatorDeferred = true;
                                                }
                                                if (terminatesStart && !this.headerAdded) {
                                                    this.startTerminalSeparatorDeferred = z2;
                                                }
                                                return asRType(insert);
                                            }
                                        }
                                    }
                                    arrayList = new ArrayList(insert8.getPages().size());
                                    arrayList2 = new ArrayList(insert8.getPages().size());
                                    if (i != 0) {
                                        int i9 = 0;
                                        while (i9 < CollectionsKt.getLastIndex(insert8.getPages()) && insert8.getPages().get(i9).getData().isEmpty()) {
                                            i9++;
                                        }
                                        num = Boxing.boxInt(i9);
                                        transformablePage = insert8.getPages().get(i9);
                                        int lastIndex2 = CollectionsKt.getLastIndex(insert8.getPages());
                                        while (lastIndex2 > 0 && insert8.getPages().get(lastIndex2).getData().isEmpty()) {
                                            lastIndex2--;
                                        }
                                        num2 = Boxing.boxInt(lastIndex2);
                                        transformablePage2 = insert8.getPages().get(lastIndex2);
                                    } else {
                                        transformablePage = null;
                                        num = null;
                                        transformablePage2 = null;
                                        num2 = null;
                                    }
                                    if (!terminatesStart && !this.headerAdded) {
                                        this.headerAdded = true;
                                        if (i != 0) {
                                            transformablePage3 = (TransformablePage) CollectionsKt.first((List<? extends Object>) this.pageStash);
                                        } else {
                                            Intrinsics.checkNotNull(transformablePage);
                                            transformablePage3 = transformablePage;
                                        }
                                        ArrayList arrayList18 = arrayList;
                                        Object first = CollectionsKt.first((List<? extends Object>) transformablePage3.getData());
                                        separatorState$onInsert$1.L$0 = insert8;
                                        separatorState$onInsert$1.L$1 = arrayList;
                                        separatorState$onInsert$1.L$2 = arrayList2;
                                        separatorState$onInsert$1.L$3 = transformablePage;
                                        separatorState$onInsert$1.L$4 = num;
                                        separatorState$onInsert$1.L$5 = transformablePage2;
                                        separatorState$onInsert$1.L$6 = num2;
                                        separatorState$onInsert$1.L$7 = transformablePage3;
                                        separatorState$onInsert$1.L$8 = arrayList18;
                                        separatorState$onInsert$1.Z$0 = terminatesEnd;
                                        separatorState$onInsert$1.I$0 = i;
                                        separatorState$onInsert$1.label = 2;
                                        Object invoke2 = ((Function3<T, T, Continuation<? super R>, Object>) this.generator).invoke(null, first, separatorState$onInsert$1);
                                        if (invoke2 != coroutine_suspended) {
                                            i2 = i;
                                            transformablePage4 = transformablePage;
                                            arrayList3 = arrayList;
                                            obj = invoke2;
                                            insert2 = insert;
                                            num3 = num;
                                            transformablePage5 = transformablePage3;
                                            z = terminatesEnd;
                                            arrayList4 = arrayList18;
                                            num4 = num2;
                                            ArrayList arrayList19 = arrayList2;
                                            TransformablePage<T> transformablePage21 = transformablePage2;
                                            int hintOriginalPageOffset2 = transformablePage5.getHintOriginalPageOffset();
                                            List<Integer> hintOriginalIndices = transformablePage5.getHintOriginalIndices();
                                            SeparatorsKt.addSeparatorPage(arrayList4, obj, null, transformablePage5, hintOriginalPageOffset2, hintOriginalIndices == null ? ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices)).intValue() : 0);
                                            i = i2;
                                            terminatesEnd = z;
                                            num2 = num4;
                                            transformablePage2 = transformablePage21;
                                            num = num3;
                                            transformablePage = transformablePage4;
                                            arrayList2 = arrayList19;
                                            arrayList = arrayList3;
                                            if (i == 0) {
                                            }
                                            separatorState$onInsert$12 = separatorState$onInsert$1;
                                            insert6 = insert2;
                                            if (terminatesEnd) {
                                            }
                                            this.endTerminalSeparatorDeferred = false;
                                            this.startTerminalSeparatorDeferred = false;
                                            loadType = insert6.getLoadType();
                                            loadType2 = LoadType.APPEND;
                                            List<TransformablePage<T>> list = this.pageStash;
                                            if (loadType == loadType2) {
                                            }
                                            LoadType loadType3 = insert6.getLoadType();
                                            insert6.getPages();
                                            return new PageEvent.Insert(loadType3, arrayList, insert6.getPlaceholdersBefore(), insert6.getPlaceholdersAfter(), insert6.getSourceLoadStates(), insert6.getMediatorLoadStates(), null);
                                        }
                                        return coroutine_suspended;
                                    }
                                    insert2 = insert;
                                    if (i == 0) {
                                        Intrinsics.checkNotNull(num);
                                        intValue = num.intValue();
                                        Integer num12 = num2;
                                        num5 = num;
                                        num6 = num12;
                                        z4 = terminatesEnd;
                                        transformablePage6 = transformablePage;
                                        i3 = 0;
                                        if (i3 < intValue) {
                                            Function3<T, T, Continuation<? super R>, Object> function32 = this.generator;
                                            separatorState$onInsert$1.L$0 = insert2;
                                            separatorState$onInsert$1.L$1 = arrayList;
                                            separatorState$onInsert$1.L$2 = arrayList2;
                                            separatorState$onInsert$1.L$3 = transformablePage6;
                                            separatorState$onInsert$1.L$4 = num5;
                                            separatorState$onInsert$1.L$5 = transformablePage2;
                                            separatorState$onInsert$1.L$6 = num6;
                                            separatorState$onInsert$1.L$7 = arrayList;
                                            num8 = num6;
                                            separatorState$onInsert$1.L$8 = null;
                                            separatorState$onInsert$1.Z$0 = z4;
                                            separatorState$onInsert$1.I$0 = i;
                                            separatorState$onInsert$1.I$1 = i3;
                                            separatorState$onInsert$1.I$2 = intValue;
                                            separatorState$onInsert$1.label = 3;
                                            Object insertInternalSeparators = SeparatorsKt.insertInternalSeparators(insert2.getPages().get(i3), function32, separatorState$onInsert$1);
                                            if (insertInternalSeparators != coroutine_suspended) {
                                                z5 = z4;
                                                obj4 = insertInternalSeparators;
                                                arrayList7 = arrayList;
                                                transformablePage9 = transformablePage6;
                                                transformablePage10 = transformablePage2;
                                                arrayList8 = arrayList7;
                                                arrayList8.add(obj4);
                                                i3++;
                                                z4 = z5;
                                                transformablePage2 = transformablePage10;
                                                transformablePage6 = transformablePage9;
                                                arrayList = arrayList7;
                                                num6 = num8;
                                                if (i3 < intValue) {
                                                    Integer num13 = num6;
                                                    if (insert2.getLoadType() == LoadType.APPEND && !this.pageStash.isEmpty()) {
                                                        TransformablePage transformablePage22 = (TransformablePage) CollectionsKt.last((List<? extends Object>) this.pageStash);
                                                        Object last = CollectionsKt.last((List<? extends Object>) transformablePage22.getData());
                                                        Intrinsics.checkNotNull(transformablePage6);
                                                        Object first2 = CollectionsKt.first((List<? extends Object>) transformablePage6.getData());
                                                        separatorState$onInsert$1.L$0 = insert2;
                                                        separatorState$onInsert$1.L$1 = arrayList;
                                                        separatorState$onInsert$1.L$2 = arrayList2;
                                                        separatorState$onInsert$1.L$3 = transformablePage6;
                                                        separatorState$onInsert$1.L$4 = num5;
                                                        separatorState$onInsert$1.L$5 = transformablePage2;
                                                        num7 = num13;
                                                        separatorState$onInsert$1.L$6 = num7;
                                                        separatorState$onInsert$1.L$7 = transformablePage22;
                                                        separatorState$onInsert$1.L$8 = null;
                                                        separatorState$onInsert$1.Z$0 = z4;
                                                        separatorState$onInsert$1.I$0 = i;
                                                        separatorState$onInsert$1.label = 4;
                                                        Object invoke3 = ((Function3<T, T, Continuation<? super R>, Object>) this.generator).invoke(last, first2, separatorState$onInsert$1);
                                                        if (invoke3 != coroutine_suspended) {
                                                            int i10 = i;
                                                            obj2 = invoke3;
                                                            i4 = i10;
                                                            transformablePage8 = transformablePage22;
                                                            TransformablePage<T> transformablePage23 = transformablePage6;
                                                            PageEvent.Insert<T> insert9 = insert2;
                                                            TransformablePage<T> transformablePage24 = transformablePage2;
                                                            ArrayList arrayList20 = arrayList;
                                                            ArrayList arrayList21 = arrayList2;
                                                            Integer num14 = num5;
                                                            ArrayList arrayList22 = arrayList20;
                                                            int hintOriginalPageOffset3 = transformablePage23.getHintOriginalPageOffset();
                                                            List<Integer> hintOriginalIndices2 = transformablePage23.getHintOriginalIndices();
                                                            SeparatorsKt.addSeparatorPage(arrayList22, obj2, transformablePage8, transformablePage23, hintOriginalPageOffset3, hintOriginalIndices2 == null ? ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices2)).intValue() : 0);
                                                            terminatesEnd = z4;
                                                            transformablePage7 = transformablePage23;
                                                            transformablePage2 = transformablePage24;
                                                            num5 = num14;
                                                            arrayList5 = arrayList21;
                                                            arrayList6 = arrayList20;
                                                            insert3 = insert9;
                                                            num9 = num7;
                                                            Intrinsics.checkNotNull(transformablePage7);
                                                            arrayList5.add(transformablePageToStash(transformablePage7));
                                                            Function3<T, T, Continuation<? super R>, Object> function33 = this.generator;
                                                            separatorState$onInsert$1.L$0 = insert3;
                                                            separatorState$onInsert$1.L$1 = arrayList6;
                                                            separatorState$onInsert$1.L$2 = arrayList5;
                                                            separatorState$onInsert$1.L$3 = num5;
                                                            separatorState$onInsert$1.L$4 = transformablePage2;
                                                            separatorState$onInsert$1.L$5 = num9;
                                                            separatorState$onInsert$1.L$6 = arrayList6;
                                                            separatorState$onInsert$1.L$7 = null;
                                                            separatorState$onInsert$1.L$8 = null;
                                                            separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                            separatorState$onInsert$1.I$0 = i4;
                                                            separatorState$onInsert$1.label = 5;
                                                            obj4 = SeparatorsKt.insertInternalSeparators(transformablePage7, function33, separatorState$onInsert$1);
                                                            if (obj4 != coroutine_suspended) {
                                                            }
                                                        }
                                                    } else {
                                                        num7 = num13;
                                                        terminatesEnd = z4;
                                                        i4 = i;
                                                        transformablePage7 = transformablePage6;
                                                        arrayList5 = arrayList2;
                                                        arrayList6 = arrayList;
                                                        insert3 = insert2;
                                                        num9 = num7;
                                                        Intrinsics.checkNotNull(transformablePage7);
                                                        arrayList5.add(transformablePageToStash(transformablePage7));
                                                        Function3<T, T, Continuation<? super R>, Object> function332 = this.generator;
                                                        separatorState$onInsert$1.L$0 = insert3;
                                                        separatorState$onInsert$1.L$1 = arrayList6;
                                                        separatorState$onInsert$1.L$2 = arrayList5;
                                                        separatorState$onInsert$1.L$3 = num5;
                                                        separatorState$onInsert$1.L$4 = transformablePage2;
                                                        separatorState$onInsert$1.L$5 = num9;
                                                        separatorState$onInsert$1.L$6 = arrayList6;
                                                        separatorState$onInsert$1.L$7 = null;
                                                        separatorState$onInsert$1.L$8 = null;
                                                        separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                        separatorState$onInsert$1.I$0 = i4;
                                                        separatorState$onInsert$1.label = 5;
                                                        obj4 = SeparatorsKt.insertInternalSeparators(transformablePage7, function332, separatorState$onInsert$1);
                                                        if (obj4 != coroutine_suspended) {
                                                            arrayList9 = arrayList6;
                                                            arrayList6.add(obj4);
                                                            List<TransformablePage<T>> pages2 = insert3.getPages();
                                                            int intValue4 = num5.intValue();
                                                            Intrinsics.checkNotNull(num9);
                                                            it = pages2.subList(intValue4, num9.intValue() + 1).iterator();
                                                            if (it.hasNext()) {
                                                                throw new UnsupportedOperationException("Empty collection can't be reduced.");
                                                            }
                                                            next = it.next();
                                                            num10 = num9;
                                                            insert2 = insert3;
                                                            arrayList = arrayList9;
                                                            arrayList2 = arrayList5;
                                                            transformablePage11 = transformablePage2;
                                                            it2 = it;
                                                            if (it2.hasNext()) {
                                                                transformablePage13 = (TransformablePage) it2.next();
                                                                TransformablePage transformablePage25 = (TransformablePage) next;
                                                                if (!transformablePage13.getData().isEmpty()) {
                                                                    Object last2 = CollectionsKt.last((List<? extends Object>) transformablePage25.getData());
                                                                    Object first3 = CollectionsKt.first((List<? extends Object>) transformablePage13.getData());
                                                                    separatorState$onInsert$1.L$0 = insert2;
                                                                    separatorState$onInsert$1.L$1 = arrayList;
                                                                    separatorState$onInsert$1.L$2 = arrayList2;
                                                                    separatorState$onInsert$1.L$3 = transformablePage11;
                                                                    separatorState$onInsert$1.L$4 = num10;
                                                                    separatorState$onInsert$1.L$5 = it2;
                                                                    separatorState$onInsert$1.L$6 = transformablePage13;
                                                                    separatorState$onInsert$1.L$7 = transformablePage25;
                                                                    separatorState$onInsert$1.L$8 = null;
                                                                    separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                                    separatorState$onInsert$1.I$0 = i4;
                                                                    separatorState$onInsert$1.label = 6;
                                                                    obj4 = ((Function3<T, T, Continuation<? super R>, Object>) this.generator).invoke(last2, first3, separatorState$onInsert$1);
                                                                    if (obj4 != coroutine_suspended) {
                                                                        transformablePage12 = transformablePage25;
                                                                        Object obj5 = obj4;
                                                                        boolean z7 = terminatesEnd;
                                                                        ArrayList arrayList23 = arrayList;
                                                                        insert5 = insert2;
                                                                        TransformablePage<T> transformablePage26 = transformablePage11;
                                                                        ArrayList arrayList24 = arrayList2;
                                                                        Iterator it5 = it2;
                                                                        Integer num15 = num10;
                                                                        ArrayList arrayList25 = arrayList23;
                                                                        if (insert5.getLoadType() != LoadType.PREPEND) {
                                                                            hintOriginalPageOffset = transformablePage12.getHintOriginalPageOffset();
                                                                        } else {
                                                                            hintOriginalPageOffset = transformablePage13.getHintOriginalPageOffset();
                                                                        }
                                                                        int i11 = i4;
                                                                        if (insert5.getLoadType() == LoadType.PREPEND) {
                                                                            List<Integer> hintOriginalIndices3 = transformablePage12.getHintOriginalIndices();
                                                                            intValue2 = hintOriginalIndices3 != null ? ((Number) CollectionsKt.last((List<? extends Object>) hintOriginalIndices3)).intValue() : CollectionsKt.getLastIndex(transformablePage12.getData());
                                                                        } else {
                                                                            List<Integer> hintOriginalIndices4 = transformablePage13.getHintOriginalIndices();
                                                                            if (hintOriginalIndices4 != null) {
                                                                                intValue2 = ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices4)).intValue();
                                                                            } else {
                                                                                i5 = 0;
                                                                                SeparatorsKt.addSeparatorPage(arrayList25, obj5, transformablePage12, transformablePage13, hintOriginalPageOffset, i5);
                                                                                i4 = i11;
                                                                                terminatesEnd = z7;
                                                                                transformablePage16 = transformablePage12;
                                                                                arrayList11 = arrayList23;
                                                                                arrayList10 = arrayList24;
                                                                                transformablePage14 = transformablePage26;
                                                                                num11 = num15;
                                                                                it3 = it5;
                                                                                transformablePage15 = transformablePage13;
                                                                                insert4 = insert5;
                                                                                if (!transformablePage15.getData().isEmpty()) {
                                                                                    arrayList10.add(transformablePageToStash(transformablePage15));
                                                                                }
                                                                                Function3<T, T, Continuation<? super R>, Object> function34 = this.generator;
                                                                                separatorState$onInsert$1.L$0 = insert4;
                                                                                separatorState$onInsert$1.L$1 = arrayList11;
                                                                                separatorState$onInsert$1.L$2 = arrayList10;
                                                                                separatorState$onInsert$1.L$3 = transformablePage14;
                                                                                separatorState$onInsert$1.L$4 = num11;
                                                                                separatorState$onInsert$1.L$5 = it3;
                                                                                separatorState$onInsert$1.L$6 = transformablePage15;
                                                                                separatorState$onInsert$1.L$7 = transformablePage16;
                                                                                separatorState$onInsert$1.L$8 = arrayList11;
                                                                                separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                                                separatorState$onInsert$1.I$0 = i4;
                                                                                separatorState$onInsert$1.label = 7;
                                                                                obj4 = SeparatorsKt.insertInternalSeparators(transformablePage15, function34, separatorState$onInsert$1);
                                                                                if (obj4 != coroutine_suspended) {
                                                                                    arrayList12 = arrayList11;
                                                                                    arrayList11.add(obj4);
                                                                                    next = transformablePage15.getData().isEmpty() ? transformablePage15 : transformablePage16;
                                                                                    it2 = it3;
                                                                                    num10 = num11;
                                                                                    transformablePage11 = transformablePage14;
                                                                                    arrayList2 = arrayList10;
                                                                                    arrayList = arrayList12;
                                                                                    insert2 = insert4;
                                                                                    if (it2.hasNext()) {
                                                                                        if (insert2.getLoadType() == LoadType.PREPEND && !this.pageStash.isEmpty()) {
                                                                                            transformablePage17 = (TransformablePage) CollectionsKt.first((List<? extends Object>) this.pageStash);
                                                                                            Intrinsics.checkNotNull(transformablePage11);
                                                                                            Object last3 = CollectionsKt.last((List<? extends Object>) transformablePage11.getData());
                                                                                            Object first4 = CollectionsKt.first((List<? extends Object>) transformablePage17.getData());
                                                                                            separatorState$onInsert$1.L$0 = insert2;
                                                                                            separatorState$onInsert$1.L$1 = arrayList;
                                                                                            separatorState$onInsert$1.L$2 = arrayList2;
                                                                                            separatorState$onInsert$1.L$3 = transformablePage11;
                                                                                            separatorState$onInsert$1.L$4 = num10;
                                                                                            separatorState$onInsert$1.L$5 = transformablePage17;
                                                                                            separatorState$onInsert$1.L$6 = null;
                                                                                            separatorState$onInsert$1.L$7 = null;
                                                                                            separatorState$onInsert$1.L$8 = null;
                                                                                            separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                                                            separatorState$onInsert$1.I$0 = i4;
                                                                                            separatorState$onInsert$1.label = 8;
                                                                                            obj4 = ((Function3<T, T, Continuation<? super R>, Object>) this.generator).invoke(last3, first4, separatorState$onInsert$1);
                                                                                            break;
                                                                                        } else {
                                                                                            transformablePage2 = transformablePage11;
                                                                                            i = i4;
                                                                                            intValue3 = num10.intValue() + 1;
                                                                                            lastIndex = CollectionsKt.getLastIndex(insert2.getPages());
                                                                                            if (intValue3 <= lastIndex) {
                                                                                                z6 = terminatesEnd;
                                                                                                arrayList13 = arrayList;
                                                                                                insert7 = insert2;
                                                                                                i6 = intValue3;
                                                                                                i7 = lastIndex;
                                                                                                arrayList14 = arrayList2;
                                                                                                transformablePage18 = transformablePage2;
                                                                                                i8 = i;
                                                                                                Function3<T, T, Continuation<? super R>, Object> function35 = this.generator;
                                                                                                separatorState$onInsert$1.L$0 = insert7;
                                                                                                separatorState$onInsert$1.L$1 = arrayList13;
                                                                                                separatorState$onInsert$1.L$2 = arrayList14;
                                                                                                separatorState$onInsert$1.L$3 = transformablePage18;
                                                                                                separatorState$onInsert$1.L$4 = arrayList13;
                                                                                                separatorState$onInsert$1.L$5 = null;
                                                                                                separatorState$onInsert$1.L$6 = null;
                                                                                                separatorState$onInsert$1.L$7 = null;
                                                                                                separatorState$onInsert$1.L$8 = null;
                                                                                                separatorState$onInsert$1.Z$0 = z6;
                                                                                                separatorState$onInsert$1.I$0 = i8;
                                                                                                separatorState$onInsert$1.I$1 = i6;
                                                                                                separatorState$onInsert$1.I$2 = i7;
                                                                                                separatorState$onInsert$1.label = 9;
                                                                                                obj4 = SeparatorsKt.insertInternalSeparators(insert7.getPages().get(i6), function35, separatorState$onInsert$1);
                                                                                                if (obj4 != coroutine_suspended) {
                                                                                                    arrayList17 = arrayList13;
                                                                                                    arrayList13.add(obj4);
                                                                                                    if (i6 == i7) {
                                                                                                        i6++;
                                                                                                        arrayList13 = arrayList17;
                                                                                                        Function3<T, T, Continuation<? super R>, Object> function352 = this.generator;
                                                                                                        separatorState$onInsert$1.L$0 = insert7;
                                                                                                        separatorState$onInsert$1.L$1 = arrayList13;
                                                                                                        separatorState$onInsert$1.L$2 = arrayList14;
                                                                                                        separatorState$onInsert$1.L$3 = transformablePage18;
                                                                                                        separatorState$onInsert$1.L$4 = arrayList13;
                                                                                                        separatorState$onInsert$1.L$5 = null;
                                                                                                        separatorState$onInsert$1.L$6 = null;
                                                                                                        separatorState$onInsert$1.L$7 = null;
                                                                                                        separatorState$onInsert$1.L$8 = null;
                                                                                                        separatorState$onInsert$1.Z$0 = z6;
                                                                                                        separatorState$onInsert$1.I$0 = i8;
                                                                                                        separatorState$onInsert$1.I$1 = i6;
                                                                                                        separatorState$onInsert$1.I$2 = i7;
                                                                                                        separatorState$onInsert$1.label = 9;
                                                                                                        obj4 = SeparatorsKt.insertInternalSeparators(insert7.getPages().get(i6), function352, separatorState$onInsert$1);
                                                                                                        if (obj4 != coroutine_suspended) {
                                                                                                        }
                                                                                                    } else {
                                                                                                        separatorState$onInsert$12 = separatorState$onInsert$1;
                                                                                                        i = i8;
                                                                                                        terminatesEnd = z6;
                                                                                                        transformablePage2 = transformablePage18;
                                                                                                        arrayList2 = arrayList14;
                                                                                                        arrayList = arrayList17;
                                                                                                        insert6 = insert7;
                                                                                                        if (terminatesEnd && !this.footerAdded) {
                                                                                                            this.footerAdded = true;
                                                                                                            if (i == 0) {
                                                                                                                transformablePage19 = (TransformablePage) CollectionsKt.last((List<? extends Object>) this.pageStash);
                                                                                                            } else {
                                                                                                                Intrinsics.checkNotNull(transformablePage2);
                                                                                                                transformablePage19 = transformablePage2;
                                                                                                            }
                                                                                                            ArrayList arrayList26 = arrayList;
                                                                                                            Object last4 = CollectionsKt.last((List<? extends Object>) transformablePage19.getData());
                                                                                                            separatorState$onInsert$12.L$0 = insert6;
                                                                                                            separatorState$onInsert$12.L$1 = arrayList;
                                                                                                            separatorState$onInsert$12.L$2 = arrayList2;
                                                                                                            separatorState$onInsert$12.L$3 = transformablePage19;
                                                                                                            separatorState$onInsert$12.L$4 = arrayList26;
                                                                                                            separatorState$onInsert$12.L$5 = null;
                                                                                                            separatorState$onInsert$12.L$6 = null;
                                                                                                            separatorState$onInsert$12.L$7 = null;
                                                                                                            separatorState$onInsert$12.L$8 = null;
                                                                                                            separatorState$onInsert$12.label = 10;
                                                                                                            invoke = ((Function3<T, T, Continuation<? super R>, Object>) this.generator).invoke(last4, null, separatorState$onInsert$12);
                                                                                                            if (invoke != coroutine_suspended) {
                                                                                                                obj3 = invoke;
                                                                                                                transformablePage20 = transformablePage19;
                                                                                                                arrayList15 = arrayList26;
                                                                                                                arrayList16 = arrayList2;
                                                                                                                int hintOriginalPageOffset4 = transformablePage20.getHintOriginalPageOffset();
                                                                                                                List<Integer> hintOriginalIndices5 = transformablePage20.getHintOriginalIndices();
                                                                                                                SeparatorsKt.addSeparatorPage(arrayList15, obj3, transformablePage20, null, hintOriginalPageOffset4, hintOriginalIndices5 == null ? ((Number) CollectionsKt.last((List<? extends Object>) hintOriginalIndices5)).intValue() : CollectionsKt.getLastIndex(transformablePage20.getData()));
                                                                                                                arrayList2 = arrayList16;
                                                                                                            }
                                                                                                        }
                                                                                                        this.endTerminalSeparatorDeferred = false;
                                                                                                        this.startTerminalSeparatorDeferred = false;
                                                                                                        loadType = insert6.getLoadType();
                                                                                                        loadType2 = LoadType.APPEND;
                                                                                                        List<TransformablePage<T>> list2 = this.pageStash;
                                                                                                        if (loadType == loadType2) {
                                                                                                            list2.addAll(arrayList2);
                                                                                                        } else {
                                                                                                            list2.addAll(0, arrayList2);
                                                                                                        }
                                                                                                        LoadType loadType32 = insert6.getLoadType();
                                                                                                        insert6.getPages();
                                                                                                        return new PageEvent.Insert(loadType32, arrayList, insert6.getPlaceholdersBefore(), insert6.getPlaceholdersAfter(), insert6.getSourceLoadStates(), insert6.getMediatorLoadStates(), null);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        i5 = intValue2;
                                                                        SeparatorsKt.addSeparatorPage(arrayList25, obj5, transformablePage12, transformablePage13, hintOriginalPageOffset, i5);
                                                                        i4 = i11;
                                                                        terminatesEnd = z7;
                                                                        transformablePage16 = transformablePage12;
                                                                        arrayList11 = arrayList23;
                                                                        arrayList10 = arrayList24;
                                                                        transformablePage14 = transformablePage26;
                                                                        num11 = num15;
                                                                        it3 = it5;
                                                                        transformablePage15 = transformablePage13;
                                                                        insert4 = insert5;
                                                                        if (!transformablePage15.getData().isEmpty()) {
                                                                        }
                                                                        Function3<T, T, Continuation<? super R>, Object> function342 = this.generator;
                                                                        separatorState$onInsert$1.L$0 = insert4;
                                                                        separatorState$onInsert$1.L$1 = arrayList11;
                                                                        separatorState$onInsert$1.L$2 = arrayList10;
                                                                        separatorState$onInsert$1.L$3 = transformablePage14;
                                                                        separatorState$onInsert$1.L$4 = num11;
                                                                        separatorState$onInsert$1.L$5 = it3;
                                                                        separatorState$onInsert$1.L$6 = transformablePage15;
                                                                        separatorState$onInsert$1.L$7 = transformablePage16;
                                                                        separatorState$onInsert$1.L$8 = arrayList11;
                                                                        separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                                        separatorState$onInsert$1.I$0 = i4;
                                                                        separatorState$onInsert$1.label = 7;
                                                                        obj4 = SeparatorsKt.insertInternalSeparators(transformablePage15, function342, separatorState$onInsert$1);
                                                                        if (obj4 != coroutine_suspended) {
                                                                        }
                                                                    }
                                                                } else {
                                                                    TransformablePage<T> transformablePage27 = transformablePage11;
                                                                    transformablePage15 = transformablePage13;
                                                                    insert4 = insert2;
                                                                    transformablePage14 = transformablePage27;
                                                                    arrayList10 = arrayList2;
                                                                    it3 = it2;
                                                                    arrayList11 = arrayList;
                                                                    num11 = num10;
                                                                    transformablePage16 = transformablePage25;
                                                                    if (!transformablePage15.getData().isEmpty()) {
                                                                    }
                                                                    Function3<T, T, Continuation<? super R>, Object> function3422 = this.generator;
                                                                    separatorState$onInsert$1.L$0 = insert4;
                                                                    separatorState$onInsert$1.L$1 = arrayList11;
                                                                    separatorState$onInsert$1.L$2 = arrayList10;
                                                                    separatorState$onInsert$1.L$3 = transformablePage14;
                                                                    separatorState$onInsert$1.L$4 = num11;
                                                                    separatorState$onInsert$1.L$5 = it3;
                                                                    separatorState$onInsert$1.L$6 = transformablePage15;
                                                                    separatorState$onInsert$1.L$7 = transformablePage16;
                                                                    separatorState$onInsert$1.L$8 = arrayList11;
                                                                    separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                                    separatorState$onInsert$1.I$0 = i4;
                                                                    separatorState$onInsert$1.label = 7;
                                                                    obj4 = SeparatorsKt.insertInternalSeparators(transformablePage15, function3422, separatorState$onInsert$1);
                                                                    if (obj4 != coroutine_suspended) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        return coroutine_suspended;
                                    }
                                    separatorState$onInsert$12 = separatorState$onInsert$1;
                                    insert6 = insert2;
                                    if (terminatesEnd) {
                                        this.footerAdded = true;
                                        if (i == 0) {
                                        }
                                        ArrayList arrayList262 = arrayList;
                                        Object last42 = CollectionsKt.last((List<? extends Object>) transformablePage19.getData());
                                        separatorState$onInsert$12.L$0 = insert6;
                                        separatorState$onInsert$12.L$1 = arrayList;
                                        separatorState$onInsert$12.L$2 = arrayList2;
                                        separatorState$onInsert$12.L$3 = transformablePage19;
                                        separatorState$onInsert$12.L$4 = arrayList262;
                                        separatorState$onInsert$12.L$5 = null;
                                        separatorState$onInsert$12.L$6 = null;
                                        separatorState$onInsert$12.L$7 = null;
                                        separatorState$onInsert$12.L$8 = null;
                                        separatorState$onInsert$12.label = 10;
                                        invoke = ((Function3<T, T, Continuation<? super R>, Object>) this.generator).invoke(last42, null, separatorState$onInsert$12);
                                        if (invoke != coroutine_suspended) {
                                        }
                                        return coroutine_suspended;
                                    }
                                    this.endTerminalSeparatorDeferred = false;
                                    this.startTerminalSeparatorDeferred = false;
                                    loadType = insert6.getLoadType();
                                    loadType2 = LoadType.APPEND;
                                    List<TransformablePage<T>> list22 = this.pageStash;
                                    if (loadType == loadType2) {
                                    }
                                    LoadType loadType322 = insert6.getLoadType();
                                    insert6.getPages();
                                    return new PageEvent.Insert(loadType322, arrayList, insert6.getPlaceholdersBefore(), insert6.getPlaceholdersAfter(), insert6.getSourceLoadStates(), insert6.getMediatorLoadStates(), null);
                                }
                            }
                        }
                        i = 1;
                        if (!this.headerAdded) {
                        }
                        if (!this.footerAdded) {
                        }
                        this.sourceStates.set(insert8.getSourceLoadStates());
                        this.mediatorStates = insert8.getMediatorLoadStates();
                        if (insert8.getLoadType() != LoadType.APPEND) {
                        }
                        if (insert8.getLoadType() != LoadType.PREPEND) {
                        }
                        if (i != 0) {
                        }
                        arrayList = new ArrayList(insert8.getPages().size());
                        arrayList2 = new ArrayList(insert8.getPages().size());
                        if (i != 0) {
                        }
                        if (!terminatesStart) {
                        }
                        insert2 = insert;
                        if (i == 0) {
                        }
                        separatorState$onInsert$12 = separatorState$onInsert$1;
                        insert6 = insert2;
                        if (terminatesEnd) {
                        }
                        this.endTerminalSeparatorDeferred = false;
                        this.startTerminalSeparatorDeferred = false;
                        loadType = insert6.getLoadType();
                        loadType2 = LoadType.APPEND;
                        List<TransformablePage<T>> list222 = this.pageStash;
                        if (loadType == loadType2) {
                        }
                        LoadType loadType3222 = insert6.getLoadType();
                        insert6.getPages();
                        return new PageEvent.Insert(loadType3222, arrayList, insert6.getPlaceholdersBefore(), insert6.getPlaceholdersAfter(), insert6.getSourceLoadStates(), insert6.getMediatorLoadStates(), null);
                    case 1:
                        insert8 = (PageEvent.Insert) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        z3 = true;
                        this.endTerminalSeparatorDeferred = false;
                        this.startTerminalSeparatorDeferred = false;
                        this.headerAdded = z3;
                        this.footerAdded = z3;
                        if (obj4 == null) {
                            return asRType(insert8);
                        }
                        LoadType loadType4 = insert8.getLoadType();
                        insert8.getPages();
                        return new PageEvent.Insert(loadType4, CollectionsKt.listOf(SeparatorsKt.separatorPage(obj4, new int[]{0}, 0, 0)), insert8.getPlaceholdersBefore(), insert8.getPlaceholdersAfter(), insert8.getSourceLoadStates(), insert8.getMediatorLoadStates(), null);
                    case 2:
                        i2 = separatorState$onInsert$1.I$0;
                        boolean z8 = separatorState$onInsert$1.Z$0;
                        ?? r6 = (List) separatorState$onInsert$1.L$8;
                        transformablePage2 = (TransformablePage) separatorState$onInsert$1.L$5;
                        arrayList2 = (ArrayList) separatorState$onInsert$1.L$2;
                        insert2 = (PageEvent.Insert) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        obj = obj4;
                        z = z8;
                        arrayList4 = r6;
                        transformablePage4 = (TransformablePage) separatorState$onInsert$1.L$3;
                        arrayList3 = (ArrayList) separatorState$onInsert$1.L$1;
                        num4 = (Integer) separatorState$onInsert$1.L$6;
                        num3 = (Integer) separatorState$onInsert$1.L$4;
                        transformablePage5 = (TransformablePage) separatorState$onInsert$1.L$7;
                        ArrayList arrayList192 = arrayList2;
                        TransformablePage<T> transformablePage212 = transformablePage2;
                        int hintOriginalPageOffset22 = transformablePage5.getHintOriginalPageOffset();
                        List<Integer> hintOriginalIndices6 = transformablePage5.getHintOriginalIndices();
                        SeparatorsKt.addSeparatorPage(arrayList4, obj, null, transformablePage5, hintOriginalPageOffset22, hintOriginalIndices6 == null ? ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices6)).intValue() : 0);
                        i = i2;
                        terminatesEnd = z;
                        num2 = num4;
                        transformablePage2 = transformablePage212;
                        num = num3;
                        transformablePage = transformablePage4;
                        arrayList2 = arrayList192;
                        arrayList = arrayList3;
                        if (i == 0) {
                        }
                        separatorState$onInsert$12 = separatorState$onInsert$1;
                        insert6 = insert2;
                        if (terminatesEnd) {
                        }
                        this.endTerminalSeparatorDeferred = false;
                        this.startTerminalSeparatorDeferred = false;
                        loadType = insert6.getLoadType();
                        loadType2 = LoadType.APPEND;
                        List<TransformablePage<T>> list2222 = this.pageStash;
                        if (loadType == loadType2) {
                        }
                        LoadType loadType32222 = insert6.getLoadType();
                        insert6.getPages();
                        return new PageEvent.Insert(loadType32222, arrayList, insert6.getPlaceholdersBefore(), insert6.getPlaceholdersAfter(), insert6.getSourceLoadStates(), insert6.getMediatorLoadStates(), null);
                    case 3:
                        intValue = separatorState$onInsert$1.I$2;
                        i3 = separatorState$onInsert$1.I$1;
                        int i12 = separatorState$onInsert$1.I$0;
                        z5 = separatorState$onInsert$1.Z$0;
                        arrayList8 = (ArrayList) separatorState$onInsert$1.L$7;
                        transformablePage10 = (TransformablePage) separatorState$onInsert$1.L$5;
                        transformablePage9 = (TransformablePage) separatorState$onInsert$1.L$3;
                        arrayList7 = (ArrayList) separatorState$onInsert$1.L$1;
                        ResultKt.throwOnFailure(obj4);
                        num8 = (Integer) separatorState$onInsert$1.L$6;
                        num5 = (Integer) separatorState$onInsert$1.L$4;
                        arrayList2 = (ArrayList) separatorState$onInsert$1.L$2;
                        insert2 = (PageEvent.Insert) separatorState$onInsert$1.L$0;
                        i = i12;
                        arrayList8.add(obj4);
                        i3++;
                        z4 = z5;
                        transformablePage2 = transformablePage10;
                        transformablePage6 = transformablePage9;
                        arrayList = arrayList7;
                        num6 = num8;
                        if (i3 < intValue) {
                        }
                        return coroutine_suspended;
                    case 4:
                        i4 = separatorState$onInsert$1.I$0;
                        boolean z9 = separatorState$onInsert$1.Z$0;
                        transformablePage8 = (TransformablePage) separatorState$onInsert$1.L$7;
                        transformablePage2 = (TransformablePage) separatorState$onInsert$1.L$5;
                        num5 = (Integer) separatorState$onInsert$1.L$4;
                        transformablePage6 = (TransformablePage) separatorState$onInsert$1.L$3;
                        arrayList2 = (ArrayList) separatorState$onInsert$1.L$2;
                        arrayList = (ArrayList) separatorState$onInsert$1.L$1;
                        insert2 = (PageEvent.Insert) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        obj2 = obj4;
                        z4 = z9;
                        num7 = (Integer) separatorState$onInsert$1.L$6;
                        TransformablePage<T> transformablePage232 = transformablePage6;
                        PageEvent.Insert<T> insert92 = insert2;
                        TransformablePage<T> transformablePage242 = transformablePage2;
                        ArrayList arrayList202 = arrayList;
                        ArrayList arrayList212 = arrayList2;
                        Integer num142 = num5;
                        ArrayList arrayList222 = arrayList202;
                        int hintOriginalPageOffset32 = transformablePage232.getHintOriginalPageOffset();
                        List<Integer> hintOriginalIndices22 = transformablePage232.getHintOriginalIndices();
                        SeparatorsKt.addSeparatorPage(arrayList222, obj2, transformablePage8, transformablePage232, hintOriginalPageOffset32, hintOriginalIndices22 == null ? ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices22)).intValue() : 0);
                        terminatesEnd = z4;
                        transformablePage7 = transformablePage232;
                        transformablePage2 = transformablePage242;
                        num5 = num142;
                        arrayList5 = arrayList212;
                        arrayList6 = arrayList202;
                        insert3 = insert92;
                        num9 = num7;
                        Intrinsics.checkNotNull(transformablePage7);
                        arrayList5.add(transformablePageToStash(transformablePage7));
                        Function3<T, T, Continuation<? super R>, Object> function3322 = this.generator;
                        separatorState$onInsert$1.L$0 = insert3;
                        separatorState$onInsert$1.L$1 = arrayList6;
                        separatorState$onInsert$1.L$2 = arrayList5;
                        separatorState$onInsert$1.L$3 = num5;
                        separatorState$onInsert$1.L$4 = transformablePage2;
                        separatorState$onInsert$1.L$5 = num9;
                        separatorState$onInsert$1.L$6 = arrayList6;
                        separatorState$onInsert$1.L$7 = null;
                        separatorState$onInsert$1.L$8 = null;
                        separatorState$onInsert$1.Z$0 = terminatesEnd;
                        separatorState$onInsert$1.I$0 = i4;
                        separatorState$onInsert$1.label = 5;
                        obj4 = SeparatorsKt.insertInternalSeparators(transformablePage7, function3322, separatorState$onInsert$1);
                        if (obj4 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 5:
                        i4 = separatorState$onInsert$1.I$0;
                        terminatesEnd = separatorState$onInsert$1.Z$0;
                        arrayList6 = (ArrayList) separatorState$onInsert$1.L$6;
                        num9 = (Integer) separatorState$onInsert$1.L$5;
                        transformablePage2 = (TransformablePage) separatorState$onInsert$1.L$4;
                        num5 = (Integer) separatorState$onInsert$1.L$3;
                        arrayList5 = (ArrayList) separatorState$onInsert$1.L$2;
                        arrayList9 = (ArrayList) separatorState$onInsert$1.L$1;
                        insert3 = (PageEvent.Insert) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        arrayList6.add(obj4);
                        List<TransformablePage<T>> pages22 = insert3.getPages();
                        int intValue42 = num5.intValue();
                        Intrinsics.checkNotNull(num9);
                        it = pages22.subList(intValue42, num9.intValue() + 1).iterator();
                        if (it.hasNext()) {
                        }
                        break;
                    case 6:
                        i4 = separatorState$onInsert$1.I$0;
                        terminatesEnd = separatorState$onInsert$1.Z$0;
                        transformablePage12 = (TransformablePage) separatorState$onInsert$1.L$7;
                        transformablePage13 = (TransformablePage) separatorState$onInsert$1.L$6;
                        it2 = (Iterator) separatorState$onInsert$1.L$5;
                        num10 = (Integer) separatorState$onInsert$1.L$4;
                        transformablePage11 = (TransformablePage) separatorState$onInsert$1.L$3;
                        arrayList2 = (ArrayList) separatorState$onInsert$1.L$2;
                        arrayList = (ArrayList) separatorState$onInsert$1.L$1;
                        insert2 = (PageEvent.Insert) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        Object obj52 = obj4;
                        boolean z72 = terminatesEnd;
                        ArrayList arrayList232 = arrayList;
                        insert5 = insert2;
                        TransformablePage<T> transformablePage262 = transformablePage11;
                        ArrayList arrayList242 = arrayList2;
                        Iterator it52 = it2;
                        Integer num152 = num10;
                        ArrayList arrayList252 = arrayList232;
                        if (insert5.getLoadType() != LoadType.PREPEND) {
                        }
                        int i112 = i4;
                        if (insert5.getLoadType() == LoadType.PREPEND) {
                        }
                        i5 = intValue2;
                        SeparatorsKt.addSeparatorPage(arrayList252, obj52, transformablePage12, transformablePage13, hintOriginalPageOffset, i5);
                        i4 = i112;
                        terminatesEnd = z72;
                        transformablePage16 = transformablePage12;
                        arrayList11 = arrayList232;
                        arrayList10 = arrayList242;
                        transformablePage14 = transformablePage262;
                        num11 = num152;
                        it3 = it52;
                        transformablePage15 = transformablePage13;
                        insert4 = insert5;
                        if (!transformablePage15.getData().isEmpty()) {
                        }
                        Function3<T, T, Continuation<? super R>, Object> function34222 = this.generator;
                        separatorState$onInsert$1.L$0 = insert4;
                        separatorState$onInsert$1.L$1 = arrayList11;
                        separatorState$onInsert$1.L$2 = arrayList10;
                        separatorState$onInsert$1.L$3 = transformablePage14;
                        separatorState$onInsert$1.L$4 = num11;
                        separatorState$onInsert$1.L$5 = it3;
                        separatorState$onInsert$1.L$6 = transformablePage15;
                        separatorState$onInsert$1.L$7 = transformablePage16;
                        separatorState$onInsert$1.L$8 = arrayList11;
                        separatorState$onInsert$1.Z$0 = terminatesEnd;
                        separatorState$onInsert$1.I$0 = i4;
                        separatorState$onInsert$1.label = 7;
                        obj4 = SeparatorsKt.insertInternalSeparators(transformablePage15, function34222, separatorState$onInsert$1);
                        if (obj4 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 7:
                        i4 = separatorState$onInsert$1.I$0;
                        terminatesEnd = separatorState$onInsert$1.Z$0;
                        arrayList11 = (ArrayList) separatorState$onInsert$1.L$8;
                        transformablePage16 = (TransformablePage) separatorState$onInsert$1.L$7;
                        transformablePage15 = (TransformablePage) separatorState$onInsert$1.L$6;
                        it3 = (Iterator) separatorState$onInsert$1.L$5;
                        num11 = (Integer) separatorState$onInsert$1.L$4;
                        transformablePage14 = (TransformablePage) separatorState$onInsert$1.L$3;
                        arrayList10 = (ArrayList) separatorState$onInsert$1.L$2;
                        arrayList12 = (ArrayList) separatorState$onInsert$1.L$1;
                        insert4 = (PageEvent.Insert) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        arrayList11.add(obj4);
                        if (transformablePage15.getData().isEmpty()) {
                        }
                        it2 = it3;
                        num10 = num11;
                        transformablePage11 = transformablePage14;
                        arrayList2 = arrayList10;
                        arrayList = arrayList12;
                        insert2 = insert4;
                        if (it2.hasNext()) {
                        }
                        return coroutine_suspended;
                    case 8:
                        i4 = separatorState$onInsert$1.I$0;
                        terminatesEnd = separatorState$onInsert$1.Z$0;
                        transformablePage17 = (TransformablePage) separatorState$onInsert$1.L$5;
                        num10 = (Integer) separatorState$onInsert$1.L$4;
                        transformablePage11 = (TransformablePage) separatorState$onInsert$1.L$3;
                        arrayList2 = (ArrayList) separatorState$onInsert$1.L$2;
                        arrayList = (ArrayList) separatorState$onInsert$1.L$1;
                        insert2 = (PageEvent.Insert) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        Object obj6 = obj4;
                        boolean z10 = terminatesEnd;
                        TransformablePage transformablePage28 = transformablePage17;
                        TransformablePage<T> transformablePage29 = transformablePage11;
                        Integer num16 = num10;
                        ArrayList arrayList27 = arrayList;
                        int hintOriginalPageOffset5 = transformablePage29.getHintOriginalPageOffset();
                        List<Integer> hintOriginalIndices7 = transformablePage29.getHintOriginalIndices();
                        SeparatorsKt.addSeparatorPage(arrayList27, obj6, transformablePage29, transformablePage28, hintOriginalPageOffset5, hintOriginalIndices7 != null ? ((Number) CollectionsKt.last((List<? extends Object>) hintOriginalIndices7)).intValue() : CollectionsKt.getLastIndex(transformablePage29.getData()));
                        terminatesEnd = z10;
                        transformablePage2 = transformablePage29;
                        num10 = num16;
                        i = i4;
                        intValue3 = num10.intValue() + 1;
                        lastIndex = CollectionsKt.getLastIndex(insert2.getPages());
                        if (intValue3 <= lastIndex) {
                        }
                        separatorState$onInsert$12 = separatorState$onInsert$1;
                        insert6 = insert2;
                        if (terminatesEnd) {
                        }
                        this.endTerminalSeparatorDeferred = false;
                        this.startTerminalSeparatorDeferred = false;
                        loadType = insert6.getLoadType();
                        loadType2 = LoadType.APPEND;
                        List<TransformablePage<T>> list22222 = this.pageStash;
                        if (loadType == loadType2) {
                        }
                        LoadType loadType322222 = insert6.getLoadType();
                        insert6.getPages();
                        return new PageEvent.Insert(loadType322222, arrayList, insert6.getPlaceholdersBefore(), insert6.getPlaceholdersAfter(), insert6.getSourceLoadStates(), insert6.getMediatorLoadStates(), null);
                    case 9:
                        i7 = separatorState$onInsert$1.I$2;
                        i6 = separatorState$onInsert$1.I$1;
                        i8 = separatorState$onInsert$1.I$0;
                        z6 = separatorState$onInsert$1.Z$0;
                        arrayList13 = (ArrayList) separatorState$onInsert$1.L$4;
                        transformablePage18 = (TransformablePage) separatorState$onInsert$1.L$3;
                        arrayList14 = (ArrayList) separatorState$onInsert$1.L$2;
                        arrayList17 = (ArrayList) separatorState$onInsert$1.L$1;
                        insert7 = (PageEvent.Insert) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        arrayList13.add(obj4);
                        if (i6 == i7) {
                        }
                        break;
                    case 10:
                        arrayList16 = (ArrayList) separatorState$onInsert$1.L$2;
                        insert6 = (PageEvent.Insert) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                        obj3 = obj4;
                        transformablePage20 = (TransformablePage) separatorState$onInsert$1.L$3;
                        arrayList = (ArrayList) separatorState$onInsert$1.L$1;
                        arrayList15 = (List) separatorState$onInsert$1.L$4;
                        int hintOriginalPageOffset42 = transformablePage20.getHintOriginalPageOffset();
                        List<Integer> hintOriginalIndices52 = transformablePage20.getHintOriginalIndices();
                        SeparatorsKt.addSeparatorPage(arrayList15, obj3, transformablePage20, null, hintOriginalPageOffset42, hintOriginalIndices52 == null ? ((Number) CollectionsKt.last((List<? extends Object>) hintOriginalIndices52)).intValue() : CollectionsKt.getLastIndex(transformablePage20.getData()));
                        arrayList2 = arrayList16;
                        this.endTerminalSeparatorDeferred = false;
                        this.startTerminalSeparatorDeferred = false;
                        loadType = insert6.getLoadType();
                        loadType2 = LoadType.APPEND;
                        List<TransformablePage<T>> list222222 = this.pageStash;
                        if (loadType == loadType2) {
                        }
                        LoadType loadType3222222 = insert6.getLoadType();
                        insert6.getPages();
                        return new PageEvent.Insert(loadType3222222, arrayList, insert6.getPlaceholdersBefore(), insert6.getPlaceholdersAfter(), insert6.getSourceLoadStates(), insert6.getMediatorLoadStates(), null);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        separatorState$onInsert$1 = new SeparatorState$onInsert$1(this, continuation);
        Object obj42 = separatorState$onInsert$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (separatorState$onInsert$1.label) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Drop<R> onDrop(PageEvent.Drop<T> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.sourceStates.set(event.getLoadType(), LoadState.NotLoading.Companion.getIncomplete$paging_common());
        if (event.getLoadType() == LoadType.PREPEND) {
            this.placeholdersBefore = event.getPlaceholdersRemaining();
            this.headerAdded = false;
        } else if (event.getLoadType() == LoadType.APPEND) {
            this.placeholdersAfter = event.getPlaceholdersRemaining();
            this.footerAdded = false;
        }
        if (this.pageStash.isEmpty()) {
            if (event.getLoadType() == LoadType.PREPEND) {
                this.startTerminalSeparatorDeferred = false;
            } else {
                this.endTerminalSeparatorDeferred = false;
            }
        }
        final IntRange intRange = new IntRange(event.getMinPageOffset(), event.getMaxPageOffset());
        CollectionsKt.removeAll((List) this.pageStash, new Function1() { // from class: androidx.paging.SeparatorState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SeparatorState.onDrop$lambda$0(IntRange.this, (TransformablePage) obj));
            }
        });
        return event;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean onDrop$lambda$0(IntRange intRange, TransformablePage stash) {
        Intrinsics.checkNotNullParameter(stash, "stash");
        for (int i : stash.getOriginalPageOffsets()) {
            if (intRange.contains(i)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object onLoadStateUpdate(PageEvent.LoadStateUpdate<T> loadStateUpdate, Continuation<? super PageEvent<R>> continuation) {
        LoadStates loadStates = this.mediatorStates;
        if (Intrinsics.areEqual(this.sourceStates.snapshot(), loadStateUpdate.getSource()) && Intrinsics.areEqual(loadStates, loadStateUpdate.getMediator())) {
            Intrinsics.checkNotNull(loadStateUpdate, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
            return loadStateUpdate;
        }
        this.sourceStates.set(loadStateUpdate.getSource());
        this.mediatorStates = loadStateUpdate.getMediator();
        if (loadStateUpdate.getMediator() != null && loadStateUpdate.getMediator().getPrepend().getEndOfPaginationReached()) {
            if (!Intrinsics.areEqual(loadStates != null ? loadStates.getPrepend() : null, loadStateUpdate.getMediator().getPrepend())) {
                return onInsert(PageEvent.Insert.Companion.Prepend(CollectionsKt.emptyList(), this.placeholdersBefore, loadStateUpdate.getSource(), loadStateUpdate.getMediator()), continuation);
            }
        }
        if (loadStateUpdate.getMediator() != null && loadStateUpdate.getMediator().getAppend().getEndOfPaginationReached()) {
            if (!Intrinsics.areEqual(loadStates != null ? loadStates.getAppend() : null, loadStateUpdate.getMediator().getAppend())) {
                return onInsert(PageEvent.Insert.Companion.Append(CollectionsKt.emptyList(), this.placeholdersAfter, loadStateUpdate.getSource(), loadStateUpdate.getMediator()), continuation);
            }
        }
        Intrinsics.checkNotNull(loadStateUpdate, "null cannot be cast to non-null type androidx.paging.PageEvent<R of androidx.paging.SeparatorState>");
        return loadStateUpdate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0081 -> B:21:0x0084). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onStaticList(PageEvent.StaticList<T> staticList, Continuation<? super PageEvent<R>> continuation) {
        SeparatorState$onStaticList$1 separatorState$onStaticList$1;
        int i;
        int size;
        ArrayList arrayList;
        int i2;
        ArrayList arrayList2;
        Object orNull;
        if (continuation instanceof SeparatorState$onStaticList$1) {
            separatorState$onStaticList$1 = (SeparatorState$onStaticList$1) continuation;
            if ((separatorState$onStaticList$1.label & Integer.MIN_VALUE) != 0) {
                separatorState$onStaticList$1.label -= Integer.MIN_VALUE;
                Object obj = separatorState$onStaticList$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = separatorState$onStaticList$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ArrayList arrayList3 = new ArrayList();
                    size = staticList.getData().size();
                    if (size >= 0) {
                        i2 = 0;
                        arrayList2 = arrayList3;
                        Object orNull2 = CollectionsKt.getOrNull(staticList.getData(), i2 - 1);
                        orNull = CollectionsKt.getOrNull(staticList.getData(), i2);
                        separatorState$onStaticList$1.L$0 = staticList;
                        separatorState$onStaticList$1.L$1 = arrayList2;
                        separatorState$onStaticList$1.L$2 = orNull;
                        separatorState$onStaticList$1.I$0 = i2;
                        separatorState$onStaticList$1.I$1 = size;
                        separatorState$onStaticList$1.label = 1;
                        obj = ((Function3<T, T, Continuation<? super R>, Object>) this.generator).invoke(orNull2, orNull, separatorState$onStaticList$1);
                        if (obj != coroutine_suspended) {
                        }
                    } else {
                        arrayList = arrayList3;
                        return new PageEvent.StaticList(arrayList, staticList.getSourceLoadStates(), staticList.getMediatorLoadStates(), 0, 0, 24, null);
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = separatorState$onStaticList$1.I$1;
                    int i4 = separatorState$onStaticList$1.I$0;
                    Object obj2 = separatorState$onStaticList$1.L$2;
                    ResultKt.throwOnFailure(obj);
                    int i5 = i3;
                    staticList = (PageEvent.StaticList) separatorState$onStaticList$1.L$0;
                    orNull = obj2;
                    ArrayList arrayList4 = (List) separatorState$onStaticList$1.L$1;
                    if (obj != null) {
                        arrayList4.add(obj);
                    }
                    if (orNull != null) {
                        arrayList4.add(orNull);
                    }
                    if (i4 == i5) {
                        int i6 = i4 + 1;
                        size = i5;
                        i2 = i6;
                        arrayList2 = arrayList4;
                        Object orNull22 = CollectionsKt.getOrNull(staticList.getData(), i2 - 1);
                        orNull = CollectionsKt.getOrNull(staticList.getData(), i2);
                        separatorState$onStaticList$1.L$0 = staticList;
                        separatorState$onStaticList$1.L$1 = arrayList2;
                        separatorState$onStaticList$1.L$2 = orNull;
                        separatorState$onStaticList$1.I$0 = i2;
                        separatorState$onStaticList$1.I$1 = size;
                        separatorState$onStaticList$1.label = 1;
                        obj = ((Function3<T, T, Continuation<? super R>, Object>) this.generator).invoke(orNull22, orNull, separatorState$onStaticList$1);
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i7 = i2;
                        i5 = size;
                        i4 = i7;
                        arrayList4 = arrayList2;
                        if (obj != null) {
                        }
                        if (orNull != null) {
                        }
                        if (i4 == i5) {
                            arrayList = arrayList4;
                            return new PageEvent.StaticList(arrayList, staticList.getSourceLoadStates(), staticList.getMediatorLoadStates(), 0, 0, 24, null);
                        }
                    }
                }
            }
        }
        separatorState$onStaticList$1 = new SeparatorState$onStaticList$1(this, continuation);
        Object obj3 = separatorState$onStaticList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = separatorState$onStaticList$1.label;
        if (i != 0) {
        }
    }

    private final <T> TransformablePage<T> transformablePageToStash(TransformablePage<T> transformablePage) {
        int[] originalPageOffsets = transformablePage.getOriginalPageOffsets();
        List listOf = CollectionsKt.listOf(CollectionsKt.first((List<? extends Object>) transformablePage.getData()), CollectionsKt.last((List<? extends Object>) transformablePage.getData()));
        int hintOriginalPageOffset = transformablePage.getHintOriginalPageOffset();
        Integer[] numArr = new Integer[2];
        List<Integer> hintOriginalIndices = transformablePage.getHintOriginalIndices();
        numArr[0] = Integer.valueOf(hintOriginalIndices != null ? ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices)).intValue() : 0);
        List<Integer> hintOriginalIndices2 = transformablePage.getHintOriginalIndices();
        numArr[1] = Integer.valueOf(hintOriginalIndices2 != null ? ((Number) CollectionsKt.last((List<? extends Object>) hintOriginalIndices2)).intValue() : CollectionsKt.getLastIndex(transformablePage.getData()));
        return new TransformablePage<>(originalPageOffsets, listOf, hintOriginalPageOffset, CollectionsKt.listOf((Object[]) numArr));
    }
}
