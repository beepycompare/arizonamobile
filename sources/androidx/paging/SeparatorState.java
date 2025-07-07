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
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u0002H\u00012\u00020\u0002B[\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012L\u0010\u0006\u001aH\b\u0001\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007¢\u0006\u0002\u0010\rJ\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010;J\"\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010>H\u0086@¢\u0006\u0002\u0010?J\"\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000A2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010AH\u0086@¢\u0006\u0002\u0010BJ\"\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000>2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010DH\u0086@¢\u0006\u0002\u0010EJ\"\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000>2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00010GH\u0086@¢\u0006\u0002\u0010HJ&\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00030%\"\b\b\u0002\u0010\u0003*\u00020\u00022\f\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00030%H\u0002J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000A*\b\u0012\u0004\u0012\u00028\u00010AJ\"\u0010L\u001a\u00020\u000f\"\b\b\u0002\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00030A2\u0006\u0010\u0004\u001a\u00020\u0005J\"\u0010M\u001a\u00020\u000f\"\b\b\u0002\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00030A2\u0006\u0010\u0004\u001a\u00020\u0005R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013RY\u0010\u0006\u001aH\b\u0001\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u00109¨\u0006N"}, d2 = {"Landroidx/paging/SeparatorState;", "R", "", ExifInterface.GPS_DIRECTION_TRUE, "terminalSeparatorType", "Landroidx/paging/TerminalSeparatorType;", "generator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", TtmlNode.ANNOTATION_POSITION_BEFORE, TtmlNode.ANNOTATION_POSITION_AFTER, "Lkotlin/coroutines/Continuation;", "(Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)V", "endTerminalSeparatorDeferred", "", "getEndTerminalSeparatorDeferred", "()Z", "setEndTerminalSeparatorDeferred", "(Z)V", "footerAdded", "getFooterAdded", "setFooterAdded", "getGenerator", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "headerAdded", "getHeaderAdded", "setHeaderAdded", "mediatorStates", "Landroidx/paging/LoadStates;", "getMediatorStates", "()Landroidx/paging/LoadStates;", "setMediatorStates", "(Landroidx/paging/LoadStates;)V", "pageStash", "", "Landroidx/paging/TransformablePage;", "getPageStash", "()Ljava/util/List;", "placeholdersAfter", "", "getPlaceholdersAfter", "()I", "setPlaceholdersAfter", "(I)V", "placeholdersBefore", "getPlaceholdersBefore", "setPlaceholdersBefore", "sourceStates", "Landroidx/paging/MutableLoadStateCollection;", "getSourceStates", "()Landroidx/paging/MutableLoadStateCollection;", "startTerminalSeparatorDeferred", "getStartTerminalSeparatorDeferred", "setStartTerminalSeparatorDeferred", "getTerminalSeparatorType", "()Landroidx/paging/TerminalSeparatorType;", "onDrop", "Landroidx/paging/PageEvent$Drop;", NotificationCompat.CATEGORY_EVENT, "onEvent", "Landroidx/paging/PageEvent;", "(Landroidx/paging/PageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onInsert", "Landroidx/paging/PageEvent$Insert;", "(Landroidx/paging/PageEvent$Insert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLoadStateUpdate", "Landroidx/paging/PageEvent$LoadStateUpdate;", "(Landroidx/paging/PageEvent$LoadStateUpdate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStaticList", "Landroidx/paging/PageEvent$StaticList;", "(Landroidx/paging/PageEvent$StaticList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformablePageToStash", "originalPage", "asRType", "terminatesEnd", "terminatesStart", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onEvent(PageEvent<T> pageEvent, Continuation<? super PageEvent<R>> continuation) {
        SeparatorState$onEvent$1 separatorState$onEvent$1;
        int i;
        SeparatorState<R, T> separatorState;
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
                        separatorState$onEvent$1.L$0 = this;
                        separatorState$onEvent$1.label = 1;
                        obj = onInsert((PageEvent.Insert) pageEvent, separatorState$onEvent$1);
                        if (obj != coroutine_suspended) {
                            separatorState = this;
                            onDrop = (PageEvent) obj;
                        }
                    } else if (pageEvent instanceof PageEvent.Drop) {
                        onDrop = onDrop((PageEvent.Drop) pageEvent);
                        separatorState = this;
                    } else if (pageEvent instanceof PageEvent.LoadStateUpdate) {
                        separatorState$onEvent$1.L$0 = this;
                        separatorState$onEvent$1.label = 2;
                        obj = onLoadStateUpdate((PageEvent.LoadStateUpdate) pageEvent, separatorState$onEvent$1);
                        if (obj != coroutine_suspended) {
                            separatorState = this;
                            onDrop = (PageEvent) obj;
                        }
                    } else if (!(pageEvent instanceof PageEvent.StaticList)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        separatorState$onEvent$1.L$0 = this;
                        separatorState$onEvent$1.label = 3;
                        obj = onStaticList((PageEvent.StaticList) pageEvent, separatorState$onEvent$1);
                        if (obj != coroutine_suspended) {
                            separatorState = this;
                            onDrop = (PageEvent) obj;
                        }
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    separatorState = (SeparatorState) separatorState$onEvent$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    onDrop = (PageEvent) obj;
                } else if (i == 2) {
                    separatorState = (SeparatorState) separatorState$onEvent$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    onDrop = (PageEvent) obj;
                } else if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    separatorState = (SeparatorState) separatorState$onEvent$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    onDrop = (PageEvent) obj;
                }
                if (separatorState.endTerminalSeparatorDeferred || separatorState.pageStash.isEmpty()) {
                    if (separatorState.startTerminalSeparatorDeferred || separatorState.pageStash.isEmpty()) {
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
        if (separatorState.endTerminalSeparatorDeferred) {
        }
        if (separatorState.startTerminalSeparatorDeferred) {
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
            if (i == 2) {
                return insert.getSourceLoadStates().getPrepend().getEndOfPaginationReached();
            }
            throw new NoWhenBranchMatchedException();
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
            if (i == 2) {
                return insert.getSourceLoadStates().getAppend().getEndOfPaginationReached();
            }
            throw new NoWhenBranchMatchedException();
        } else if (insert.getSourceLoadStates().getAppend().getEndOfPaginationReached()) {
            LoadStates mediatorLoadStates = insert.getMediatorLoadStates();
            return mediatorLoadStates == null || (append = mediatorLoadStates.getAppend()) == null || append.getEndOfPaginationReached();
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:204:0x06ee, code lost:
        if (r2 == r4) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0682  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x069d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x072d  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x076a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0770  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0782  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x079b  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x07a4  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x07d5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x07f1  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02ec  */
    /* JADX WARN: Type inference failed for: r1v61, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:139:0x047f -> B:140:0x0486). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:193:0x0682 -> B:17:0x00d2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:219:0x076a -> B:220:0x076b). Please submit an issue!!! */
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
        SeparatorState<R, T> separatorState;
        PageEvent.Insert<T> insert2;
        TransformablePage<T> transformablePage3;
        int i2;
        Object obj;
        boolean z;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        TransformablePage<T> transformablePage4;
        Integer num3;
        TransformablePage<T> transformablePage5;
        Integer num4;
        boolean z2;
        boolean z3;
        SeparatorState<R, T> separatorState2;
        SeparatorState$onInsert$1 separatorState$onInsert$12;
        PageEvent.Insert<T> insert3;
        SeparatorState<R, T> separatorState3;
        ArrayList arrayList6;
        ArrayList arrayList7;
        TransformablePage<T> transformablePage6;
        Integer num5;
        Integer num6;
        TransformablePage<T> transformablePage7;
        int i3;
        boolean z4;
        ArrayList arrayList8;
        ArrayList arrayList9;
        PageEvent.Insert<T> insert4;
        SeparatorState<R, T> separatorState4;
        int i4;
        Integer num7;
        int i5;
        TransformablePage<T> transformablePage8;
        ArrayList arrayList10;
        ArrayList arrayList11;
        PageEvent.Insert<T> insert5;
        SeparatorState<R, T> separatorState5;
        TransformablePage transformablePage9;
        SeparatorState<R, T> separatorState6;
        Object obj2;
        TransformablePage<T> transformablePage10;
        TransformablePage<T> transformablePage11;
        PageEvent.Insert<T> insert6;
        SeparatorState<R, T> separatorState7;
        ArrayList arrayList12;
        TransformablePage<T> transformablePage12;
        TransformablePage<T> transformablePage13;
        ArrayList arrayList13;
        Integer num8;
        ArrayList arrayList14;
        Iterator it;
        TransformablePage next;
        Integer num9;
        SeparatorState<R, T> separatorState8;
        PageEvent.Insert<T> insert7;
        ArrayList arrayList15;
        ArrayList arrayList16;
        TransformablePage<T> transformablePage14;
        Iterator it2;
        Object obj3;
        Iterator it3;
        TransformablePage<T> transformablePage15;
        TransformablePage transformablePage16;
        ArrayList arrayList17;
        TransformablePage<T> transformablePage17;
        Integer num10;
        Iterator it4;
        TransformablePage<T> transformablePage18;
        TransformablePage transformablePage19;
        PageEvent.Insert<T> insert8;
        ArrayList arrayList18;
        SeparatorState<R, T> separatorState9;
        ArrayList arrayList19;
        PageEvent.Insert<T> insert9;
        int hintOriginalPageOffset;
        int i6;
        int intValue;
        TransformablePage<T> transformablePage20;
        TransformablePage transformablePage21;
        int intValue2;
        int lastIndex;
        boolean z5;
        int i7;
        PageEvent.Insert<T> insert10;
        int i8;
        ArrayList arrayList20;
        TransformablePage<T> transformablePage22;
        SeparatorState<R, T> separatorState10;
        TransformablePage<T> transformablePage23;
        Object invoke;
        Object obj4;
        TransformablePage<T> transformablePage24;
        ArrayList arrayList21;
        ArrayList arrayList22;
        ArrayList arrayList23;
        PageEvent.Insert<T> insert11 = insert;
        if (continuation instanceof SeparatorState$onInsert$1) {
            separatorState$onInsert$1 = (SeparatorState$onInsert$1) continuation;
            if ((separatorState$onInsert$1.label & Integer.MIN_VALUE) != 0) {
                separatorState$onInsert$1.label -= Integer.MIN_VALUE;
                Object obj5 = separatorState$onInsert$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (separatorState$onInsert$1.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj5);
                        boolean terminatesStart = terminatesStart(insert11, this.terminalSeparatorType);
                        terminatesEnd = terminatesEnd(insert11, this.terminalSeparatorType);
                        List<TransformablePage<T>> pages = insert11.getPages();
                        if (!(pages instanceof Collection) || !pages.isEmpty()) {
                            Iterator it5 = pages.iterator();
                            while (it5.hasNext()) {
                                if (!((TransformablePage) it5.next()).getData().isEmpty()) {
                                    i = 0;
                                    if (!this.headerAdded && insert11.getLoadType() == LoadType.PREPEND && i == 0) {
                                        throw new IllegalArgumentException("Additional prepend event after prepend state is done".toString());
                                    }
                                    if (!this.footerAdded && insert11.getLoadType() == LoadType.APPEND && i == 0) {
                                        throw new IllegalArgumentException("Additional append event after append state is done".toString());
                                    }
                                    this.sourceStates.set(insert11.getSourceLoadStates());
                                    this.mediatorStates = insert11.getMediatorLoadStates();
                                    if (insert11.getLoadType() != LoadType.APPEND) {
                                        this.placeholdersBefore = insert11.getPlaceholdersBefore();
                                    }
                                    if (insert11.getLoadType() != LoadType.PREPEND) {
                                        this.placeholdersAfter = insert11.getPlaceholdersAfter();
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
                                                separatorState$onInsert$1.L$0 = this;
                                                separatorState$onInsert$1.L$1 = insert11;
                                                z3 = true;
                                                separatorState$onInsert$1.label = 1;
                                                obj5 = function3.invoke(null, null, separatorState$onInsert$1);
                                                if (obj5 != coroutine_suspended) {
                                                    separatorState2 = this;
                                                    separatorState2.endTerminalSeparatorDeferred = false;
                                                    separatorState2.startTerminalSeparatorDeferred = false;
                                                    separatorState2.headerAdded = z3;
                                                    separatorState2.footerAdded = z3;
                                                    if (obj5 != null) {
                                                        return separatorState2.asRType(insert11);
                                                    }
                                                    LoadType loadType = insert11.getLoadType();
                                                    insert11.getPages();
                                                    return new PageEvent.Insert(loadType, CollectionsKt.listOf(SeparatorsKt.separatorPage(obj5, new int[]{0}, 0, 0)), insert11.getPlaceholdersBefore(), insert11.getPlaceholdersAfter(), insert11.getSourceLoadStates(), insert11.getMediatorLoadStates(), null);
                                                }
                                                return coroutine_suspended;
                                            }
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
                                    arrayList = new ArrayList(insert11.getPages().size());
                                    arrayList2 = new ArrayList(insert11.getPages().size());
                                    if (i != 0) {
                                        int i9 = 0;
                                        while (i9 < CollectionsKt.getLastIndex(insert11.getPages()) && insert11.getPages().get(i9).getData().isEmpty()) {
                                            i9++;
                                        }
                                        num = Boxing.boxInt(i9);
                                        transformablePage = insert11.getPages().get(i9);
                                        int lastIndex2 = CollectionsKt.getLastIndex(insert11.getPages());
                                        while (lastIndex2 > 0 && insert11.getPages().get(lastIndex2).getData().isEmpty()) {
                                            lastIndex2--;
                                        }
                                        num2 = Boxing.boxInt(lastIndex2);
                                        transformablePage2 = insert11.getPages().get(lastIndex2);
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
                                        ArrayList arrayList24 = arrayList;
                                        Object first = CollectionsKt.first((List<? extends Object>) transformablePage3.getData());
                                        separatorState$onInsert$1.L$0 = this;
                                        separatorState$onInsert$1.L$1 = insert11;
                                        separatorState$onInsert$1.L$2 = arrayList;
                                        separatorState$onInsert$1.L$3 = arrayList2;
                                        separatorState$onInsert$1.L$4 = transformablePage;
                                        separatorState$onInsert$1.L$5 = num;
                                        separatorState$onInsert$1.L$6 = transformablePage2;
                                        separatorState$onInsert$1.L$7 = num2;
                                        separatorState$onInsert$1.L$8 = transformablePage3;
                                        separatorState$onInsert$1.L$9 = arrayList24;
                                        separatorState$onInsert$1.Z$0 = terminatesEnd;
                                        separatorState$onInsert$1.I$0 = i;
                                        separatorState$onInsert$1.label = 2;
                                        Object invoke2 = ((Function3<T, T, Continuation<? super R>, Object>) this.generator).invoke(null, first, separatorState$onInsert$1);
                                        if (invoke2 != coroutine_suspended) {
                                            insert2 = insert11;
                                            i2 = i;
                                            obj = invoke2;
                                            separatorState = this;
                                            z = terminatesEnd;
                                            arrayList3 = arrayList24;
                                            arrayList4 = arrayList2;
                                            arrayList5 = arrayList;
                                            transformablePage4 = transformablePage;
                                            num3 = num;
                                            transformablePage5 = transformablePage3;
                                            num4 = num2;
                                            TransformablePage<T> transformablePage25 = transformablePage2;
                                            int hintOriginalPageOffset2 = transformablePage5.getHintOriginalPageOffset();
                                            List<Integer> hintOriginalIndices = transformablePage5.getHintOriginalIndices();
                                            SeparatorsKt.addSeparatorPage(arrayList3, obj, null, transformablePage5, hintOriginalPageOffset2, hintOriginalIndices == null ? ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices)).intValue() : 0);
                                            terminatesEnd = z;
                                            i = i2;
                                            num2 = num4;
                                            transformablePage2 = transformablePage25;
                                            num = num3;
                                            transformablePage = transformablePage4;
                                            arrayList2 = arrayList4;
                                            arrayList = arrayList5;
                                            if (i != 0) {
                                            }
                                        }
                                        return coroutine_suspended;
                                    }
                                    separatorState = this;
                                    insert2 = insert11;
                                    if (i != 0) {
                                        Intrinsics.checkNotNull(num);
                                        int intValue3 = num.intValue();
                                        Integer num11 = num2;
                                        transformablePage6 = transformablePage;
                                        num5 = num11;
                                        TransformablePage<T> transformablePage26 = transformablePage2;
                                        num6 = num;
                                        transformablePage7 = transformablePage26;
                                        i3 = intValue3;
                                        z4 = terminatesEnd;
                                        arrayList8 = arrayList2;
                                        arrayList9 = arrayList;
                                        insert4 = insert2;
                                        separatorState4 = separatorState;
                                        i4 = 0;
                                        if (i4 < i3) {
                                            Function3<T, T, Continuation<? super R>, Object> function32 = separatorState4.generator;
                                            separatorState$onInsert$1.L$0 = separatorState4;
                                            separatorState$onInsert$1.L$1 = insert4;
                                            separatorState$onInsert$1.L$2 = arrayList9;
                                            separatorState$onInsert$1.L$3 = arrayList8;
                                            separatorState$onInsert$1.L$4 = transformablePage6;
                                            separatorState$onInsert$1.L$5 = num6;
                                            separatorState$onInsert$1.L$6 = transformablePage7;
                                            separatorState$onInsert$1.L$7 = num5;
                                            separatorState$onInsert$1.L$8 = arrayList9;
                                            Integer num12 = num5;
                                            separatorState$onInsert$1.L$9 = null;
                                            separatorState$onInsert$1.Z$0 = z4;
                                            separatorState$onInsert$1.I$0 = i;
                                            separatorState$onInsert$1.I$1 = i4;
                                            separatorState$onInsert$1.I$2 = i3;
                                            separatorState$onInsert$1.label = 3;
                                            obj5 = SeparatorsKt.insertInternalSeparators(insert4.getPages().get(i4), function32, separatorState$onInsert$1);
                                            if (obj5 != coroutine_suspended) {
                                                separatorState7 = separatorState4;
                                                num5 = num12;
                                                arrayList12 = arrayList9;
                                                transformablePage12 = transformablePage6;
                                                transformablePage13 = transformablePage7;
                                                arrayList13 = arrayList12;
                                                arrayList13.add(obj5);
                                                i4++;
                                                transformablePage7 = transformablePage13;
                                                transformablePage6 = transformablePage12;
                                                arrayList9 = arrayList12;
                                                separatorState4 = separatorState7;
                                                if (i4 < i3) {
                                                    Integer num13 = num5;
                                                    if (insert4.getLoadType() == LoadType.APPEND && !separatorState4.pageStash.isEmpty()) {
                                                        TransformablePage transformablePage27 = (TransformablePage) CollectionsKt.last((List<? extends Object>) separatorState4.pageStash);
                                                        Object last = CollectionsKt.last((List<? extends Object>) transformablePage27.getData());
                                                        Intrinsics.checkNotNull(transformablePage6);
                                                        Object first2 = CollectionsKt.first((List<? extends Object>) transformablePage6.getData());
                                                        separatorState$onInsert$1.L$0 = separatorState4;
                                                        separatorState$onInsert$1.L$1 = insert4;
                                                        separatorState$onInsert$1.L$2 = arrayList9;
                                                        separatorState$onInsert$1.L$3 = arrayList8;
                                                        separatorState$onInsert$1.L$4 = transformablePage6;
                                                        separatorState$onInsert$1.L$5 = num6;
                                                        separatorState$onInsert$1.L$6 = transformablePage7;
                                                        num7 = num13;
                                                        separatorState$onInsert$1.L$7 = num7;
                                                        separatorState$onInsert$1.L$8 = transformablePage27;
                                                        separatorState$onInsert$1.L$9 = null;
                                                        separatorState$onInsert$1.Z$0 = z4;
                                                        separatorState$onInsert$1.I$0 = i;
                                                        separatorState$onInsert$1.label = 4;
                                                        Object invoke3 = ((Function3<T, T, Continuation<? super R>, Object>) separatorState4.generator).invoke(last, first2, separatorState$onInsert$1);
                                                        if (invoke3 != coroutine_suspended) {
                                                            transformablePage9 = transformablePage27;
                                                            i5 = i;
                                                            separatorState6 = separatorState4;
                                                            obj2 = invoke3;
                                                            transformablePage10 = transformablePage7;
                                                            transformablePage11 = transformablePage6;
                                                            insert6 = insert4;
                                                            ArrayList arrayList25 = arrayList9;
                                                            ArrayList arrayList26 = arrayList8;
                                                            Integer num14 = num6;
                                                            ArrayList arrayList27 = arrayList25;
                                                            int hintOriginalPageOffset3 = transformablePage11.getHintOriginalPageOffset();
                                                            List<Integer> hintOriginalIndices2 = transformablePage11.getHintOriginalIndices();
                                                            SeparatorsKt.addSeparatorPage(arrayList27, obj2, transformablePage9, transformablePage11, hintOriginalPageOffset3, hintOriginalIndices2 == null ? ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices2)).intValue() : 0);
                                                            terminatesEnd = z4;
                                                            transformablePage8 = transformablePage11;
                                                            num6 = num14;
                                                            arrayList10 = arrayList26;
                                                            arrayList11 = arrayList25;
                                                            insert5 = insert6;
                                                            separatorState5 = separatorState6;
                                                            transformablePage7 = transformablePage10;
                                                            num8 = num7;
                                                            Intrinsics.checkNotNull(transformablePage8);
                                                            arrayList10.add(separatorState5.transformablePageToStash(transformablePage8));
                                                            Function3<T, T, Continuation<? super R>, Object> function33 = separatorState5.generator;
                                                            separatorState$onInsert$1.L$0 = separatorState5;
                                                            separatorState$onInsert$1.L$1 = insert5;
                                                            separatorState$onInsert$1.L$2 = arrayList11;
                                                            separatorState$onInsert$1.L$3 = arrayList10;
                                                            separatorState$onInsert$1.L$4 = num6;
                                                            separatorState$onInsert$1.L$5 = transformablePage7;
                                                            separatorState$onInsert$1.L$6 = num8;
                                                            separatorState$onInsert$1.L$7 = arrayList11;
                                                            separatorState$onInsert$1.L$8 = null;
                                                            separatorState$onInsert$1.L$9 = null;
                                                            separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                            separatorState$onInsert$1.I$0 = i5;
                                                            separatorState$onInsert$1.label = 5;
                                                            obj5 = SeparatorsKt.insertInternalSeparators(transformablePage8, function33, separatorState$onInsert$1);
                                                            if (obj5 != coroutine_suspended) {
                                                            }
                                                        }
                                                    } else {
                                                        num7 = num13;
                                                        terminatesEnd = z4;
                                                        i5 = i;
                                                        transformablePage8 = transformablePage6;
                                                        arrayList10 = arrayList8;
                                                        arrayList11 = arrayList9;
                                                        insert5 = insert4;
                                                        separatorState5 = separatorState4;
                                                        num8 = num7;
                                                        Intrinsics.checkNotNull(transformablePage8);
                                                        arrayList10.add(separatorState5.transformablePageToStash(transformablePage8));
                                                        Function3<T, T, Continuation<? super R>, Object> function332 = separatorState5.generator;
                                                        separatorState$onInsert$1.L$0 = separatorState5;
                                                        separatorState$onInsert$1.L$1 = insert5;
                                                        separatorState$onInsert$1.L$2 = arrayList11;
                                                        separatorState$onInsert$1.L$3 = arrayList10;
                                                        separatorState$onInsert$1.L$4 = num6;
                                                        separatorState$onInsert$1.L$5 = transformablePage7;
                                                        separatorState$onInsert$1.L$6 = num8;
                                                        separatorState$onInsert$1.L$7 = arrayList11;
                                                        separatorState$onInsert$1.L$8 = null;
                                                        separatorState$onInsert$1.L$9 = null;
                                                        separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                        separatorState$onInsert$1.I$0 = i5;
                                                        separatorState$onInsert$1.label = 5;
                                                        obj5 = SeparatorsKt.insertInternalSeparators(transformablePage8, function332, separatorState$onInsert$1);
                                                        if (obj5 != coroutine_suspended) {
                                                            arrayList14 = arrayList11;
                                                            arrayList11.add(obj5);
                                                            List<TransformablePage<T>> pages2 = insert5.getPages();
                                                            int intValue4 = num6.intValue();
                                                            Intrinsics.checkNotNull(num8);
                                                            it = pages2.subList(intValue4, num8.intValue() + 1).iterator();
                                                            if (it.hasNext()) {
                                                                throw new UnsupportedOperationException("Empty collection can't be reduced.");
                                                            }
                                                            next = it.next();
                                                            num9 = num8;
                                                            separatorState8 = separatorState5;
                                                            insert7 = insert5;
                                                            arrayList15 = arrayList14;
                                                            arrayList16 = arrayList10;
                                                            transformablePage14 = transformablePage7;
                                                            it2 = it;
                                                            if (it2.hasNext()) {
                                                                TransformablePage<T> transformablePage28 = (TransformablePage) it2.next();
                                                                TransformablePage transformablePage29 = (TransformablePage) next;
                                                                if (!transformablePage28.getData().isEmpty()) {
                                                                    Object last2 = CollectionsKt.last((List<? extends Object>) transformablePage29.getData());
                                                                    Object first3 = CollectionsKt.first((List<? extends Object>) transformablePage28.getData());
                                                                    separatorState$onInsert$1.L$0 = separatorState8;
                                                                    separatorState$onInsert$1.L$1 = insert7;
                                                                    separatorState$onInsert$1.L$2 = arrayList15;
                                                                    separatorState$onInsert$1.L$3 = arrayList16;
                                                                    separatorState$onInsert$1.L$4 = transformablePage14;
                                                                    separatorState$onInsert$1.L$5 = num9;
                                                                    separatorState$onInsert$1.L$6 = it2;
                                                                    separatorState$onInsert$1.L$7 = transformablePage28;
                                                                    separatorState$onInsert$1.L$8 = transformablePage29;
                                                                    separatorState$onInsert$1.L$9 = null;
                                                                    separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                                    separatorState$onInsert$1.I$0 = i5;
                                                                    separatorState$onInsert$1.label = 6;
                                                                    Object invoke4 = ((Function3<T, T, Continuation<? super R>, Object>) separatorState8.generator).invoke(last2, first3, separatorState$onInsert$1);
                                                                    if (invoke4 != coroutine_suspended) {
                                                                        obj3 = invoke4;
                                                                        it3 = it2;
                                                                        transformablePage15 = transformablePage28;
                                                                        transformablePage16 = transformablePage29;
                                                                        boolean z6 = terminatesEnd;
                                                                        insert9 = insert7;
                                                                        SeparatorState<R, T> separatorState11 = separatorState8;
                                                                        ArrayList arrayList28 = arrayList16;
                                                                        ArrayList arrayList29 = arrayList15;
                                                                        Integer num15 = num9;
                                                                        TransformablePage<T> transformablePage30 = transformablePage14;
                                                                        ArrayList arrayList30 = arrayList29;
                                                                        if (insert9.getLoadType() != LoadType.PREPEND) {
                                                                            hintOriginalPageOffset = transformablePage16.getHintOriginalPageOffset();
                                                                        } else {
                                                                            hintOriginalPageOffset = transformablePage15.getHintOriginalPageOffset();
                                                                        }
                                                                        if (insert9.getLoadType() == LoadType.PREPEND) {
                                                                            List<Integer> hintOriginalIndices3 = transformablePage16.getHintOriginalIndices();
                                                                            intValue = hintOriginalIndices3 != null ? ((Number) CollectionsKt.last((List<? extends Object>) hintOriginalIndices3)).intValue() : CollectionsKt.getLastIndex(transformablePage16.getData());
                                                                        } else {
                                                                            List<Integer> hintOriginalIndices4 = transformablePage15.getHintOriginalIndices();
                                                                            if (hintOriginalIndices4 != null) {
                                                                                intValue = ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices4)).intValue();
                                                                            } else {
                                                                                i6 = 0;
                                                                                SeparatorsKt.addSeparatorPage(arrayList30, obj3, transformablePage16, transformablePage15, hintOriginalPageOffset, i6);
                                                                                terminatesEnd = z6;
                                                                                transformablePage19 = transformablePage16;
                                                                                transformablePage18 = transformablePage15;
                                                                                arrayList18 = arrayList29;
                                                                                insert8 = insert9;
                                                                                separatorState9 = separatorState11;
                                                                                arrayList17 = arrayList28;
                                                                                transformablePage17 = transformablePage30;
                                                                                num10 = num15;
                                                                                it4 = it3;
                                                                                if (!transformablePage18.getData().isEmpty()) {
                                                                                    arrayList17.add(separatorState9.transformablePageToStash(transformablePage18));
                                                                                }
                                                                                Function3<T, T, Continuation<? super R>, Object> function34 = separatorState9.generator;
                                                                                separatorState$onInsert$1.L$0 = separatorState9;
                                                                                separatorState$onInsert$1.L$1 = insert8;
                                                                                separatorState$onInsert$1.L$2 = arrayList18;
                                                                                separatorState$onInsert$1.L$3 = arrayList17;
                                                                                separatorState$onInsert$1.L$4 = transformablePage17;
                                                                                separatorState$onInsert$1.L$5 = num10;
                                                                                separatorState$onInsert$1.L$6 = it4;
                                                                                separatorState$onInsert$1.L$7 = transformablePage18;
                                                                                separatorState$onInsert$1.L$8 = transformablePage19;
                                                                                separatorState$onInsert$1.L$9 = arrayList18;
                                                                                separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                                                separatorState$onInsert$1.I$0 = i5;
                                                                                separatorState$onInsert$1.label = 7;
                                                                                obj5 = SeparatorsKt.insertInternalSeparators(transformablePage18, function34, separatorState$onInsert$1);
                                                                                if (obj5 != coroutine_suspended) {
                                                                                    arrayList19 = arrayList18;
                                                                                    PageEvent.Insert<T> insert12 = insert8;
                                                                                    it2 = it4;
                                                                                    arrayList16 = arrayList17;
                                                                                    separatorState8 = separatorState9;
                                                                                    arrayList18.add(obj5);
                                                                                    next = transformablePage18.getData().isEmpty() ? transformablePage18 : transformablePage19;
                                                                                    num9 = num10;
                                                                                    transformablePage14 = transformablePage17;
                                                                                    arrayList15 = arrayList19;
                                                                                    insert7 = insert12;
                                                                                    if (it2.hasNext()) {
                                                                                        if (insert7.getLoadType() == LoadType.PREPEND && !separatorState8.pageStash.isEmpty()) {
                                                                                            transformablePage21 = (TransformablePage) CollectionsKt.first((List<? extends Object>) separatorState8.pageStash);
                                                                                            Intrinsics.checkNotNull(transformablePage14);
                                                                                            Object last3 = CollectionsKt.last((List<? extends Object>) transformablePage14.getData());
                                                                                            Object first4 = CollectionsKt.first((List<? extends Object>) transformablePage21.getData());
                                                                                            separatorState$onInsert$1.L$0 = separatorState8;
                                                                                            separatorState$onInsert$1.L$1 = insert7;
                                                                                            separatorState$onInsert$1.L$2 = arrayList15;
                                                                                            separatorState$onInsert$1.L$3 = arrayList16;
                                                                                            separatorState$onInsert$1.L$4 = transformablePage14;
                                                                                            separatorState$onInsert$1.L$5 = num9;
                                                                                            separatorState$onInsert$1.L$6 = transformablePage21;
                                                                                            separatorState$onInsert$1.L$7 = null;
                                                                                            separatorState$onInsert$1.L$8 = null;
                                                                                            separatorState$onInsert$1.L$9 = null;
                                                                                            separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                                                            separatorState$onInsert$1.I$0 = i5;
                                                                                            separatorState$onInsert$1.label = 8;
                                                                                            obj5 = ((Function3<T, T, Continuation<? super R>, Object>) separatorState8.generator).invoke(last3, first4, separatorState$onInsert$1);
                                                                                            break;
                                                                                        } else {
                                                                                            transformablePage20 = transformablePage14;
                                                                                            i = i5;
                                                                                            intValue2 = num9.intValue() + 1;
                                                                                            lastIndex = CollectionsKt.getLastIndex(insert7.getPages());
                                                                                            if (intValue2 > lastIndex) {
                                                                                                z5 = terminatesEnd;
                                                                                                i7 = i;
                                                                                                insert10 = insert7;
                                                                                                i8 = intValue2;
                                                                                                arrayList7 = arrayList16;
                                                                                                arrayList20 = arrayList15;
                                                                                                transformablePage22 = transformablePage20;
                                                                                                separatorState10 = separatorState8;
                                                                                                Function3<T, T, Continuation<? super R>, Object> function35 = separatorState10.generator;
                                                                                                separatorState$onInsert$1.L$0 = separatorState10;
                                                                                                separatorState$onInsert$1.L$1 = insert10;
                                                                                                separatorState$onInsert$1.L$2 = arrayList20;
                                                                                                separatorState$onInsert$1.L$3 = arrayList7;
                                                                                                separatorState$onInsert$1.L$4 = transformablePage22;
                                                                                                separatorState$onInsert$1.L$5 = arrayList20;
                                                                                                separatorState$onInsert$1.L$6 = null;
                                                                                                separatorState$onInsert$1.L$7 = null;
                                                                                                separatorState$onInsert$1.L$8 = null;
                                                                                                separatorState$onInsert$1.L$9 = null;
                                                                                                separatorState$onInsert$1.Z$0 = z5;
                                                                                                separatorState$onInsert$1.I$0 = i7;
                                                                                                separatorState$onInsert$1.I$1 = i8;
                                                                                                separatorState$onInsert$1.I$2 = lastIndex;
                                                                                                separatorState$onInsert$1.label = 9;
                                                                                                obj5 = SeparatorsKt.insertInternalSeparators(insert10.getPages().get(i8), function35, separatorState$onInsert$1);
                                                                                                if (obj5 != coroutine_suspended) {
                                                                                                    arrayList6 = arrayList20;
                                                                                                    arrayList20.add(obj5);
                                                                                                    if (i8 == lastIndex) {
                                                                                                        i8++;
                                                                                                        arrayList20 = arrayList6;
                                                                                                        Function3<T, T, Continuation<? super R>, Object> function352 = separatorState10.generator;
                                                                                                        separatorState$onInsert$1.L$0 = separatorState10;
                                                                                                        separatorState$onInsert$1.L$1 = insert10;
                                                                                                        separatorState$onInsert$1.L$2 = arrayList20;
                                                                                                        separatorState$onInsert$1.L$3 = arrayList7;
                                                                                                        separatorState$onInsert$1.L$4 = transformablePage22;
                                                                                                        separatorState$onInsert$1.L$5 = arrayList20;
                                                                                                        separatorState$onInsert$1.L$6 = null;
                                                                                                        separatorState$onInsert$1.L$7 = null;
                                                                                                        separatorState$onInsert$1.L$8 = null;
                                                                                                        separatorState$onInsert$1.L$9 = null;
                                                                                                        separatorState$onInsert$1.Z$0 = z5;
                                                                                                        separatorState$onInsert$1.I$0 = i7;
                                                                                                        separatorState$onInsert$1.I$1 = i8;
                                                                                                        separatorState$onInsert$1.I$2 = lastIndex;
                                                                                                        separatorState$onInsert$1.label = 9;
                                                                                                        obj5 = SeparatorsKt.insertInternalSeparators(insert10.getPages().get(i8), function352, separatorState$onInsert$1);
                                                                                                        if (obj5 != coroutine_suspended) {
                                                                                                        }
                                                                                                    } else {
                                                                                                        separatorState$onInsert$12 = separatorState$onInsert$1;
                                                                                                        separatorState3 = separatorState10;
                                                                                                        i = i7;
                                                                                                        terminatesEnd = z5;
                                                                                                        transformablePage2 = transformablePage22;
                                                                                                        insert3 = insert10;
                                                                                                        if (terminatesEnd && !separatorState3.footerAdded) {
                                                                                                            separatorState3.footerAdded = true;
                                                                                                            if (i == 0) {
                                                                                                                transformablePage23 = (TransformablePage) CollectionsKt.last((List<? extends Object>) separatorState3.pageStash);
                                                                                                            } else {
                                                                                                                Intrinsics.checkNotNull(transformablePage2);
                                                                                                                transformablePage23 = transformablePage2;
                                                                                                            }
                                                                                                            ArrayList arrayList31 = arrayList6;
                                                                                                            Object last4 = CollectionsKt.last((List<? extends Object>) transformablePage23.getData());
                                                                                                            separatorState$onInsert$12.L$0 = separatorState3;
                                                                                                            separatorState$onInsert$12.L$1 = insert3;
                                                                                                            separatorState$onInsert$12.L$2 = arrayList6;
                                                                                                            separatorState$onInsert$12.L$3 = arrayList7;
                                                                                                            separatorState$onInsert$12.L$4 = transformablePage23;
                                                                                                            separatorState$onInsert$12.L$5 = arrayList31;
                                                                                                            separatorState$onInsert$12.L$6 = null;
                                                                                                            separatorState$onInsert$12.L$7 = null;
                                                                                                            separatorState$onInsert$12.L$8 = null;
                                                                                                            separatorState$onInsert$12.L$9 = null;
                                                                                                            separatorState$onInsert$12.label = 10;
                                                                                                            invoke = ((Function3<T, T, Continuation<? super R>, Object>) separatorState3.generator).invoke(last4, null, separatorState$onInsert$12);
                                                                                                            if (invoke != coroutine_suspended) {
                                                                                                                obj4 = invoke;
                                                                                                                transformablePage24 = transformablePage23;
                                                                                                                arrayList21 = arrayList31;
                                                                                                                arrayList22 = arrayList7;
                                                                                                                arrayList23 = arrayList6;
                                                                                                                int hintOriginalPageOffset4 = transformablePage24.getHintOriginalPageOffset();
                                                                                                                List<Integer> hintOriginalIndices5 = transformablePage24.getHintOriginalIndices();
                                                                                                                SeparatorsKt.addSeparatorPage(arrayList21, obj4, transformablePage24, null, hintOriginalPageOffset4, hintOriginalIndices5 == null ? ((Number) CollectionsKt.last((List<? extends Object>) hintOriginalIndices5)).intValue() : CollectionsKt.getLastIndex(transformablePage24.getData()));
                                                                                                                arrayList7 = arrayList22;
                                                                                                                arrayList6 = arrayList23;
                                                                                                            }
                                                                                                        }
                                                                                                        separatorState3.endTerminalSeparatorDeferred = false;
                                                                                                        separatorState3.startTerminalSeparatorDeferred = false;
                                                                                                        if (insert3.getLoadType() != LoadType.APPEND) {
                                                                                                            separatorState3.pageStash.addAll(arrayList7);
                                                                                                        } else {
                                                                                                            separatorState3.pageStash.addAll(0, arrayList7);
                                                                                                        }
                                                                                                        LoadType loadType2 = insert3.getLoadType();
                                                                                                        insert3.getPages();
                                                                                                        return new PageEvent.Insert(loadType2, arrayList6, insert3.getPlaceholdersBefore(), insert3.getPlaceholdersAfter(), insert3.getSourceLoadStates(), insert3.getMediatorLoadStates(), null);
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                separatorState$onInsert$12 = separatorState$onInsert$1;
                                                                                                transformablePage2 = transformablePage20;
                                                                                                insert3 = insert7;
                                                                                                separatorState3 = separatorState8;
                                                                                                arrayList7 = arrayList16;
                                                                                                arrayList6 = arrayList15;
                                                                                                if (terminatesEnd) {
                                                                                                    separatorState3.footerAdded = true;
                                                                                                    if (i == 0) {
                                                                                                    }
                                                                                                    ArrayList arrayList312 = arrayList6;
                                                                                                    Object last42 = CollectionsKt.last((List<? extends Object>) transformablePage23.getData());
                                                                                                    separatorState$onInsert$12.L$0 = separatorState3;
                                                                                                    separatorState$onInsert$12.L$1 = insert3;
                                                                                                    separatorState$onInsert$12.L$2 = arrayList6;
                                                                                                    separatorState$onInsert$12.L$3 = arrayList7;
                                                                                                    separatorState$onInsert$12.L$4 = transformablePage23;
                                                                                                    separatorState$onInsert$12.L$5 = arrayList312;
                                                                                                    separatorState$onInsert$12.L$6 = null;
                                                                                                    separatorState$onInsert$12.L$7 = null;
                                                                                                    separatorState$onInsert$12.L$8 = null;
                                                                                                    separatorState$onInsert$12.L$9 = null;
                                                                                                    separatorState$onInsert$12.label = 10;
                                                                                                    invoke = ((Function3<T, T, Continuation<? super R>, Object>) separatorState3.generator).invoke(last42, null, separatorState$onInsert$12);
                                                                                                    if (invoke != coroutine_suspended) {
                                                                                                    }
                                                                                                }
                                                                                                separatorState3.endTerminalSeparatorDeferred = false;
                                                                                                separatorState3.startTerminalSeparatorDeferred = false;
                                                                                                if (insert3.getLoadType() != LoadType.APPEND) {
                                                                                                }
                                                                                                LoadType loadType22 = insert3.getLoadType();
                                                                                                insert3.getPages();
                                                                                                return new PageEvent.Insert(loadType22, arrayList6, insert3.getPlaceholdersBefore(), insert3.getPlaceholdersAfter(), insert3.getSourceLoadStates(), insert3.getMediatorLoadStates(), null);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                        i6 = intValue;
                                                                        SeparatorsKt.addSeparatorPage(arrayList30, obj3, transformablePage16, transformablePage15, hintOriginalPageOffset, i6);
                                                                        terminatesEnd = z6;
                                                                        transformablePage19 = transformablePage16;
                                                                        transformablePage18 = transformablePage15;
                                                                        arrayList18 = arrayList29;
                                                                        insert8 = insert9;
                                                                        separatorState9 = separatorState11;
                                                                        arrayList17 = arrayList28;
                                                                        transformablePage17 = transformablePage30;
                                                                        num10 = num15;
                                                                        it4 = it3;
                                                                        if (!transformablePage18.getData().isEmpty()) {
                                                                        }
                                                                        Function3<T, T, Continuation<? super R>, Object> function342 = separatorState9.generator;
                                                                        separatorState$onInsert$1.L$0 = separatorState9;
                                                                        separatorState$onInsert$1.L$1 = insert8;
                                                                        separatorState$onInsert$1.L$2 = arrayList18;
                                                                        separatorState$onInsert$1.L$3 = arrayList17;
                                                                        separatorState$onInsert$1.L$4 = transformablePage17;
                                                                        separatorState$onInsert$1.L$5 = num10;
                                                                        separatorState$onInsert$1.L$6 = it4;
                                                                        separatorState$onInsert$1.L$7 = transformablePage18;
                                                                        separatorState$onInsert$1.L$8 = transformablePage19;
                                                                        separatorState$onInsert$1.L$9 = arrayList18;
                                                                        separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                                        separatorState$onInsert$1.I$0 = i5;
                                                                        separatorState$onInsert$1.label = 7;
                                                                        obj5 = SeparatorsKt.insertInternalSeparators(transformablePage18, function342, separatorState$onInsert$1);
                                                                        if (obj5 != coroutine_suspended) {
                                                                        }
                                                                    }
                                                                } else {
                                                                    separatorState9 = separatorState8;
                                                                    arrayList17 = arrayList16;
                                                                    it4 = it2;
                                                                    insert8 = insert7;
                                                                    transformablePage17 = transformablePage14;
                                                                    transformablePage18 = transformablePage28;
                                                                    arrayList18 = arrayList15;
                                                                    num10 = num9;
                                                                    transformablePage19 = transformablePage29;
                                                                    if (!transformablePage18.getData().isEmpty()) {
                                                                    }
                                                                    Function3<T, T, Continuation<? super R>, Object> function3422 = separatorState9.generator;
                                                                    separatorState$onInsert$1.L$0 = separatorState9;
                                                                    separatorState$onInsert$1.L$1 = insert8;
                                                                    separatorState$onInsert$1.L$2 = arrayList18;
                                                                    separatorState$onInsert$1.L$3 = arrayList17;
                                                                    separatorState$onInsert$1.L$4 = transformablePage17;
                                                                    separatorState$onInsert$1.L$5 = num10;
                                                                    separatorState$onInsert$1.L$6 = it4;
                                                                    separatorState$onInsert$1.L$7 = transformablePage18;
                                                                    separatorState$onInsert$1.L$8 = transformablePage19;
                                                                    separatorState$onInsert$1.L$9 = arrayList18;
                                                                    separatorState$onInsert$1.Z$0 = terminatesEnd;
                                                                    separatorState$onInsert$1.I$0 = i5;
                                                                    separatorState$onInsert$1.label = 7;
                                                                    obj5 = SeparatorsKt.insertInternalSeparators(transformablePage18, function3422, separatorState$onInsert$1);
                                                                    if (obj5 != coroutine_suspended) {
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
                                    insert3 = insert2;
                                    separatorState3 = separatorState;
                                    arrayList6 = arrayList;
                                    arrayList7 = arrayList2;
                                    if (terminatesEnd) {
                                    }
                                    separatorState3.endTerminalSeparatorDeferred = false;
                                    separatorState3.startTerminalSeparatorDeferred = false;
                                    if (insert3.getLoadType() != LoadType.APPEND) {
                                    }
                                    LoadType loadType222 = insert3.getLoadType();
                                    insert3.getPages();
                                    return new PageEvent.Insert(loadType222, arrayList6, insert3.getPlaceholdersBefore(), insert3.getPlaceholdersAfter(), insert3.getSourceLoadStates(), insert3.getMediatorLoadStates(), null);
                                }
                            }
                        }
                        i = 1;
                        if (!this.headerAdded) {
                        }
                        if (!this.footerAdded) {
                        }
                        this.sourceStates.set(insert11.getSourceLoadStates());
                        this.mediatorStates = insert11.getMediatorLoadStates();
                        if (insert11.getLoadType() != LoadType.APPEND) {
                        }
                        if (insert11.getLoadType() != LoadType.PREPEND) {
                        }
                        if (i != 0) {
                        }
                        arrayList = new ArrayList(insert11.getPages().size());
                        arrayList2 = new ArrayList(insert11.getPages().size());
                        if (i != 0) {
                        }
                        if (!terminatesStart) {
                        }
                        separatorState = this;
                        insert2 = insert11;
                        if (i != 0) {
                        }
                        break;
                    case 1:
                        insert11 = (PageEvent.Insert) separatorState$onInsert$1.L$1;
                        separatorState2 = (SeparatorState) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj5);
                        z3 = true;
                        separatorState2.endTerminalSeparatorDeferred = false;
                        separatorState2.startTerminalSeparatorDeferred = false;
                        separatorState2.headerAdded = z3;
                        separatorState2.footerAdded = z3;
                        if (obj5 != null) {
                        }
                        break;
                    case 2:
                        i2 = separatorState$onInsert$1.I$0;
                        boolean z7 = separatorState$onInsert$1.Z$0;
                        transformablePage2 = (TransformablePage) separatorState$onInsert$1.L$6;
                        insert2 = (PageEvent.Insert) separatorState$onInsert$1.L$1;
                        ResultKt.throwOnFailure(obj5);
                        z = z7;
                        arrayList3 = (List) separatorState$onInsert$1.L$9;
                        arrayList5 = (ArrayList) separatorState$onInsert$1.L$2;
                        separatorState = (SeparatorState) separatorState$onInsert$1.L$0;
                        obj = obj5;
                        num4 = (Integer) separatorState$onInsert$1.L$7;
                        transformablePage4 = (TransformablePage) separatorState$onInsert$1.L$4;
                        arrayList4 = (ArrayList) separatorState$onInsert$1.L$3;
                        transformablePage5 = (TransformablePage) separatorState$onInsert$1.L$8;
                        num3 = (Integer) separatorState$onInsert$1.L$5;
                        TransformablePage<T> transformablePage252 = transformablePage2;
                        int hintOriginalPageOffset22 = transformablePage5.getHintOriginalPageOffset();
                        List<Integer> hintOriginalIndices6 = transformablePage5.getHintOriginalIndices();
                        SeparatorsKt.addSeparatorPage(arrayList3, obj, null, transformablePage5, hintOriginalPageOffset22, hintOriginalIndices6 == null ? ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices6)).intValue() : 0);
                        terminatesEnd = z;
                        i = i2;
                        num2 = num4;
                        transformablePage2 = transformablePage252;
                        num = num3;
                        transformablePage = transformablePage4;
                        arrayList2 = arrayList4;
                        arrayList = arrayList5;
                        if (i != 0) {
                        }
                        break;
                    case 3:
                        int i10 = separatorState$onInsert$1.I$2;
                        i4 = separatorState$onInsert$1.I$1;
                        i = separatorState$onInsert$1.I$0;
                        boolean z8 = separatorState$onInsert$1.Z$0;
                        arrayList13 = (ArrayList) separatorState$onInsert$1.L$8;
                        transformablePage13 = (TransformablePage) separatorState$onInsert$1.L$6;
                        transformablePage12 = (TransformablePage) separatorState$onInsert$1.L$4;
                        arrayList12 = (ArrayList) separatorState$onInsert$1.L$2;
                        ResultKt.throwOnFailure(obj5);
                        z4 = z8;
                        num5 = (Integer) separatorState$onInsert$1.L$7;
                        num6 = (Integer) separatorState$onInsert$1.L$5;
                        arrayList8 = (ArrayList) separatorState$onInsert$1.L$3;
                        insert4 = (PageEvent.Insert) separatorState$onInsert$1.L$1;
                        separatorState7 = (SeparatorState) separatorState$onInsert$1.L$0;
                        i3 = i10;
                        arrayList13.add(obj5);
                        i4++;
                        transformablePage7 = transformablePage13;
                        transformablePage6 = transformablePage12;
                        arrayList9 = arrayList12;
                        separatorState4 = separatorState7;
                        if (i4 < i3) {
                        }
                        return coroutine_suspended;
                    case 4:
                        i5 = separatorState$onInsert$1.I$0;
                        boolean z9 = separatorState$onInsert$1.Z$0;
                        num6 = (Integer) separatorState$onInsert$1.L$5;
                        arrayList8 = (ArrayList) separatorState$onInsert$1.L$3;
                        arrayList9 = (ArrayList) separatorState$onInsert$1.L$2;
                        ResultKt.throwOnFailure(obj5);
                        z4 = z9;
                        num7 = (Integer) separatorState$onInsert$1.L$7;
                        transformablePage9 = (TransformablePage) separatorState$onInsert$1.L$8;
                        separatorState6 = (SeparatorState) separatorState$onInsert$1.L$0;
                        insert6 = (PageEvent.Insert) separatorState$onInsert$1.L$1;
                        obj2 = obj5;
                        transformablePage10 = (TransformablePage) separatorState$onInsert$1.L$6;
                        transformablePage11 = (TransformablePage) separatorState$onInsert$1.L$4;
                        ArrayList arrayList252 = arrayList9;
                        ArrayList arrayList262 = arrayList8;
                        Integer num142 = num6;
                        ArrayList arrayList272 = arrayList252;
                        int hintOriginalPageOffset32 = transformablePage11.getHintOriginalPageOffset();
                        List<Integer> hintOriginalIndices22 = transformablePage11.getHintOriginalIndices();
                        SeparatorsKt.addSeparatorPage(arrayList272, obj2, transformablePage9, transformablePage11, hintOriginalPageOffset32, hintOriginalIndices22 == null ? ((Number) CollectionsKt.first((List<? extends Object>) hintOriginalIndices22)).intValue() : 0);
                        terminatesEnd = z4;
                        transformablePage8 = transformablePage11;
                        num6 = num142;
                        arrayList10 = arrayList262;
                        arrayList11 = arrayList252;
                        insert5 = insert6;
                        separatorState5 = separatorState6;
                        transformablePage7 = transformablePage10;
                        num8 = num7;
                        Intrinsics.checkNotNull(transformablePage8);
                        arrayList10.add(separatorState5.transformablePageToStash(transformablePage8));
                        Function3<T, T, Continuation<? super R>, Object> function3322 = separatorState5.generator;
                        separatorState$onInsert$1.L$0 = separatorState5;
                        separatorState$onInsert$1.L$1 = insert5;
                        separatorState$onInsert$1.L$2 = arrayList11;
                        separatorState$onInsert$1.L$3 = arrayList10;
                        separatorState$onInsert$1.L$4 = num6;
                        separatorState$onInsert$1.L$5 = transformablePage7;
                        separatorState$onInsert$1.L$6 = num8;
                        separatorState$onInsert$1.L$7 = arrayList11;
                        separatorState$onInsert$1.L$8 = null;
                        separatorState$onInsert$1.L$9 = null;
                        separatorState$onInsert$1.Z$0 = terminatesEnd;
                        separatorState$onInsert$1.I$0 = i5;
                        separatorState$onInsert$1.label = 5;
                        obj5 = SeparatorsKt.insertInternalSeparators(transformablePage8, function3322, separatorState$onInsert$1);
                        if (obj5 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 5:
                        i5 = separatorState$onInsert$1.I$0;
                        terminatesEnd = separatorState$onInsert$1.Z$0;
                        arrayList11 = (ArrayList) separatorState$onInsert$1.L$7;
                        num8 = (Integer) separatorState$onInsert$1.L$6;
                        transformablePage7 = (TransformablePage) separatorState$onInsert$1.L$5;
                        num6 = (Integer) separatorState$onInsert$1.L$4;
                        arrayList10 = (ArrayList) separatorState$onInsert$1.L$3;
                        arrayList14 = (ArrayList) separatorState$onInsert$1.L$2;
                        insert5 = (PageEvent.Insert) separatorState$onInsert$1.L$1;
                        separatorState5 = (SeparatorState) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj5);
                        arrayList11.add(obj5);
                        List<TransformablePage<T>> pages22 = insert5.getPages();
                        int intValue42 = num6.intValue();
                        Intrinsics.checkNotNull(num8);
                        it = pages22.subList(intValue42, num8.intValue() + 1).iterator();
                        if (it.hasNext()) {
                        }
                        break;
                    case 6:
                        i5 = separatorState$onInsert$1.I$0;
                        terminatesEnd = separatorState$onInsert$1.Z$0;
                        TransformablePage transformablePage31 = (TransformablePage) separatorState$onInsert$1.L$8;
                        num9 = (Integer) separatorState$onInsert$1.L$5;
                        transformablePage14 = (TransformablePage) separatorState$onInsert$1.L$4;
                        arrayList16 = (ArrayList) separatorState$onInsert$1.L$3;
                        arrayList15 = (ArrayList) separatorState$onInsert$1.L$2;
                        insert7 = (PageEvent.Insert) separatorState$onInsert$1.L$1;
                        separatorState8 = (SeparatorState) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj5);
                        obj3 = obj5;
                        it3 = (Iterator) separatorState$onInsert$1.L$6;
                        transformablePage15 = (TransformablePage) separatorState$onInsert$1.L$7;
                        transformablePage16 = transformablePage31;
                        boolean z62 = terminatesEnd;
                        insert9 = insert7;
                        SeparatorState<R, T> separatorState112 = separatorState8;
                        ArrayList arrayList282 = arrayList16;
                        ArrayList arrayList292 = arrayList15;
                        Integer num152 = num9;
                        TransformablePage<T> transformablePage302 = transformablePage14;
                        ArrayList arrayList302 = arrayList292;
                        if (insert9.getLoadType() != LoadType.PREPEND) {
                        }
                        if (insert9.getLoadType() == LoadType.PREPEND) {
                        }
                        i6 = intValue;
                        SeparatorsKt.addSeparatorPage(arrayList302, obj3, transformablePage16, transformablePage15, hintOriginalPageOffset, i6);
                        terminatesEnd = z62;
                        transformablePage19 = transformablePage16;
                        transformablePage18 = transformablePage15;
                        arrayList18 = arrayList292;
                        insert8 = insert9;
                        separatorState9 = separatorState112;
                        arrayList17 = arrayList282;
                        transformablePage17 = transformablePage302;
                        num10 = num152;
                        it4 = it3;
                        if (!transformablePage18.getData().isEmpty()) {
                        }
                        Function3<T, T, Continuation<? super R>, Object> function34222 = separatorState9.generator;
                        separatorState$onInsert$1.L$0 = separatorState9;
                        separatorState$onInsert$1.L$1 = insert8;
                        separatorState$onInsert$1.L$2 = arrayList18;
                        separatorState$onInsert$1.L$3 = arrayList17;
                        separatorState$onInsert$1.L$4 = transformablePage17;
                        separatorState$onInsert$1.L$5 = num10;
                        separatorState$onInsert$1.L$6 = it4;
                        separatorState$onInsert$1.L$7 = transformablePage18;
                        separatorState$onInsert$1.L$8 = transformablePage19;
                        separatorState$onInsert$1.L$9 = arrayList18;
                        separatorState$onInsert$1.Z$0 = terminatesEnd;
                        separatorState$onInsert$1.I$0 = i5;
                        separatorState$onInsert$1.label = 7;
                        obj5 = SeparatorsKt.insertInternalSeparators(transformablePage18, function34222, separatorState$onInsert$1);
                        if (obj5 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 7:
                        i5 = separatorState$onInsert$1.I$0;
                        terminatesEnd = separatorState$onInsert$1.Z$0;
                        arrayList18 = (ArrayList) separatorState$onInsert$1.L$9;
                        transformablePage19 = (TransformablePage) separatorState$onInsert$1.L$8;
                        transformablePage18 = (TransformablePage) separatorState$onInsert$1.L$7;
                        it4 = (Iterator) separatorState$onInsert$1.L$6;
                        num10 = (Integer) separatorState$onInsert$1.L$5;
                        transformablePage17 = (TransformablePage) separatorState$onInsert$1.L$4;
                        arrayList17 = (ArrayList) separatorState$onInsert$1.L$3;
                        arrayList19 = (ArrayList) separatorState$onInsert$1.L$2;
                        insert8 = (PageEvent.Insert) separatorState$onInsert$1.L$1;
                        separatorState9 = (SeparatorState) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj5);
                        PageEvent.Insert<T> insert122 = insert8;
                        it2 = it4;
                        arrayList16 = arrayList17;
                        separatorState8 = separatorState9;
                        arrayList18.add(obj5);
                        if (transformablePage18.getData().isEmpty()) {
                        }
                        num9 = num10;
                        transformablePage14 = transformablePage17;
                        arrayList15 = arrayList19;
                        insert7 = insert122;
                        if (it2.hasNext()) {
                        }
                        return coroutine_suspended;
                    case 8:
                        i5 = separatorState$onInsert$1.I$0;
                        terminatesEnd = separatorState$onInsert$1.Z$0;
                        transformablePage21 = (TransformablePage) separatorState$onInsert$1.L$6;
                        num9 = (Integer) separatorState$onInsert$1.L$5;
                        transformablePage14 = (TransformablePage) separatorState$onInsert$1.L$4;
                        arrayList16 = (ArrayList) separatorState$onInsert$1.L$3;
                        arrayList15 = (ArrayList) separatorState$onInsert$1.L$2;
                        insert7 = (PageEvent.Insert) separatorState$onInsert$1.L$1;
                        separatorState8 = (SeparatorState) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj5);
                        Object obj6 = obj5;
                        boolean z10 = terminatesEnd;
                        TransformablePage transformablePage32 = transformablePage21;
                        Integer num16 = num9;
                        transformablePage20 = transformablePage14;
                        ArrayList arrayList32 = arrayList15;
                        int hintOriginalPageOffset5 = transformablePage20.getHintOriginalPageOffset();
                        List<Integer> hintOriginalIndices7 = transformablePage20.getHintOriginalIndices();
                        SeparatorsKt.addSeparatorPage(arrayList32, obj6, transformablePage20, transformablePage32, hintOriginalPageOffset5, hintOriginalIndices7 != null ? ((Number) CollectionsKt.last((List<? extends Object>) hintOriginalIndices7)).intValue() : CollectionsKt.getLastIndex(transformablePage20.getData()));
                        terminatesEnd = z10;
                        num9 = num16;
                        i = i5;
                        intValue2 = num9.intValue() + 1;
                        lastIndex = CollectionsKt.getLastIndex(insert7.getPages());
                        if (intValue2 > lastIndex) {
                        }
                        break;
                    case 9:
                        lastIndex = separatorState$onInsert$1.I$2;
                        i8 = separatorState$onInsert$1.I$1;
                        i7 = separatorState$onInsert$1.I$0;
                        z5 = separatorState$onInsert$1.Z$0;
                        arrayList20 = (ArrayList) separatorState$onInsert$1.L$5;
                        transformablePage22 = (TransformablePage) separatorState$onInsert$1.L$4;
                        arrayList7 = (ArrayList) separatorState$onInsert$1.L$3;
                        arrayList6 = (ArrayList) separatorState$onInsert$1.L$2;
                        insert10 = (PageEvent.Insert) separatorState$onInsert$1.L$1;
                        separatorState10 = (SeparatorState) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj5);
                        arrayList20.add(obj5);
                        if (i8 == lastIndex) {
                        }
                        break;
                    case 10:
                        arrayList22 = (ArrayList) separatorState$onInsert$1.L$3;
                        arrayList23 = (ArrayList) separatorState$onInsert$1.L$2;
                        insert3 = (PageEvent.Insert) separatorState$onInsert$1.L$1;
                        separatorState3 = (SeparatorState) separatorState$onInsert$1.L$0;
                        ResultKt.throwOnFailure(obj5);
                        arrayList21 = (List) separatorState$onInsert$1.L$5;
                        obj4 = obj5;
                        transformablePage24 = (TransformablePage) separatorState$onInsert$1.L$4;
                        int hintOriginalPageOffset42 = transformablePage24.getHintOriginalPageOffset();
                        List<Integer> hintOriginalIndices52 = transformablePage24.getHintOriginalIndices();
                        SeparatorsKt.addSeparatorPage(arrayList21, obj4, transformablePage24, null, hintOriginalPageOffset42, hintOriginalIndices52 == null ? ((Number) CollectionsKt.last((List<? extends Object>) hintOriginalIndices52)).intValue() : CollectionsKt.getLastIndex(transformablePage24.getData()));
                        arrayList7 = arrayList22;
                        arrayList6 = arrayList23;
                        separatorState3.endTerminalSeparatorDeferred = false;
                        separatorState3.startTerminalSeparatorDeferred = false;
                        if (insert3.getLoadType() != LoadType.APPEND) {
                        }
                        LoadType loadType2222 = insert3.getLoadType();
                        insert3.getPages();
                        return new PageEvent.Insert(loadType2222, arrayList6, insert3.getPlaceholdersBefore(), insert3.getPlaceholdersAfter(), insert3.getSourceLoadStates(), insert3.getMediatorLoadStates(), null);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        separatorState$onInsert$1 = new SeparatorState$onInsert$1(this, continuation);
        Object obj52 = separatorState$onInsert$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (separatorState$onInsert$1.label) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PageEvent.Drop<R> onDrop(PageEvent.Drop<T> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.sourceStates.set(event.getLoadType(), LoadState.NotLoading.Companion.getIncomplete$paging_common_release());
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
        CollectionsKt.removeAll((List) this.pageStash, new Function1<TransformablePage<T>, Boolean>() { // from class: androidx.paging.SeparatorState$onDrop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return invoke((TransformablePage) ((TransformablePage) obj));
            }

            public final Boolean invoke(TransformablePage<T> stash) {
                Intrinsics.checkNotNullParameter(stash, "stash");
                int[] originalPageOffsets = stash.getOriginalPageOffsets();
                IntRange intRange2 = IntRange.this;
                int length = originalPageOffsets.length;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (intRange2.contains(originalPageOffsets[i])) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                return Boolean.valueOf(z);
            }
        });
        return event;
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
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0088 -> B:21:0x008b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onStaticList(PageEvent.StaticList<T> staticList, Continuation<? super PageEvent<R>> continuation) {
        SeparatorState$onStaticList$1 separatorState$onStaticList$1;
        int i;
        ArrayList arrayList;
        int size;
        int i2;
        SeparatorState<R, T> separatorState;
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
                    arrayList = new ArrayList();
                    size = staticList.getData().size();
                    if (size >= 0) {
                        i2 = 0;
                        separatorState = this;
                        arrayList2 = arrayList;
                        Object orNull2 = CollectionsKt.getOrNull(staticList.getData(), i2 - 1);
                        orNull = CollectionsKt.getOrNull(staticList.getData(), i2);
                        separatorState$onStaticList$1.L$0 = separatorState;
                        separatorState$onStaticList$1.L$1 = staticList;
                        separatorState$onStaticList$1.L$2 = arrayList2;
                        separatorState$onStaticList$1.L$3 = orNull;
                        separatorState$onStaticList$1.I$0 = i2;
                        separatorState$onStaticList$1.I$1 = size;
                        separatorState$onStaticList$1.label = 1;
                        obj = ((Function3<T, T, Continuation<? super R>, Object>) separatorState.generator).invoke(orNull2, orNull, separatorState$onStaticList$1);
                        if (obj != coroutine_suspended) {
                        }
                    }
                    return new PageEvent.StaticList(arrayList, staticList.getSourceLoadStates(), staticList.getMediatorLoadStates());
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = separatorState$onStaticList$1.I$1;
                    int i4 = separatorState$onStaticList$1.I$0;
                    Object obj2 = separatorState$onStaticList$1.L$3;
                    separatorState = (SeparatorState) separatorState$onStaticList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    int i5 = i3;
                    staticList = (PageEvent.StaticList) separatorState$onStaticList$1.L$1;
                    orNull = obj2;
                    ArrayList arrayList3 = (List) separatorState$onStaticList$1.L$2;
                    if (obj != null) {
                        arrayList3.add(obj);
                    }
                    if (orNull != null) {
                        arrayList3.add(orNull);
                    }
                    if (i4 == i5) {
                        int i6 = i4 + 1;
                        size = i5;
                        i2 = i6;
                        arrayList2 = arrayList3;
                        Object orNull22 = CollectionsKt.getOrNull(staticList.getData(), i2 - 1);
                        orNull = CollectionsKt.getOrNull(staticList.getData(), i2);
                        separatorState$onStaticList$1.L$0 = separatorState;
                        separatorState$onStaticList$1.L$1 = staticList;
                        separatorState$onStaticList$1.L$2 = arrayList2;
                        separatorState$onStaticList$1.L$3 = orNull;
                        separatorState$onStaticList$1.I$0 = i2;
                        separatorState$onStaticList$1.I$1 = size;
                        separatorState$onStaticList$1.label = 1;
                        obj = ((Function3<T, T, Continuation<? super R>, Object>) separatorState.generator).invoke(orNull22, orNull, separatorState$onStaticList$1);
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        int i7 = i2;
                        i5 = size;
                        i4 = i7;
                        arrayList3 = arrayList2;
                        if (obj != null) {
                        }
                        if (orNull != null) {
                        }
                        if (i4 == i5) {
                            arrayList = arrayList3;
                            return new PageEvent.StaticList(arrayList, staticList.getSourceLoadStates(), staticList.getMediatorLoadStates());
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
