package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.InvalidationTracker;
import androidx.room.RxRoom;
import androidx.room.coroutines.FlowUtil;
import androidx.sqlite.SQLiteConnection;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.rx2.RxCompletableKt;
import kotlinx.coroutines.rx2.RxConvertKt;
import kotlinx.coroutines.rx2.RxMaybeKt;
import kotlinx.coroutines.rx2.RxSingleKt;
/* compiled from: RxRoom.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/room/RxRoom;", "", "<init>", "()V", "Companion", "room-rxjava2_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public class RxRoom {
    public static final Companion Companion = new Companion(null);
    public static final Object NOTHING = new Object();

    @JvmStatic
    public static final Completable createCompletable(RoomDatabase roomDatabase, boolean z, boolean z2, Function1<? super SQLiteConnection, Unit> function1) {
        return Companion.createCompletable(roomDatabase, z, z2, function1);
    }

    @Deprecated(message = "No longer used by generated code.")
    @JvmStatic
    public static final <T> Flowable<T> createFlowable(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<? extends T> callable) {
        return Companion.createFlowable(roomDatabase, z, strArr, callable);
    }

    @JvmStatic
    public static final <T> Flowable<T> createFlowable(RoomDatabase roomDatabase, boolean z, String[] strArr, Function1<? super SQLiteConnection, ? extends T> function1) {
        return Companion.createFlowable(roomDatabase, z, strArr, function1);
    }

    @JvmStatic
    public static final Flowable<Object> createFlowable(RoomDatabase roomDatabase, String... strArr) {
        return Companion.createFlowable(roomDatabase, strArr);
    }

    @Deprecated(message = "No longer used by generated code.")
    @JvmStatic
    public static final <T> Flowable<T> createFlowable(RoomDatabase roomDatabase, String[] strArr, Callable<? extends T> callable) {
        return Companion.createFlowable(roomDatabase, strArr, callable);
    }

    @JvmStatic
    public static final <T> Maybe<T> createMaybe(RoomDatabase roomDatabase, boolean z, boolean z2, Function1<? super SQLiteConnection, ? extends T> function1) {
        return Companion.createMaybe(roomDatabase, z, z2, function1);
    }

    @Deprecated(message = "No longer used by generated code.")
    @JvmStatic
    public static final <T> Observable<T> createObservable(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<? extends T> callable) {
        return Companion.createObservable(roomDatabase, z, strArr, callable);
    }

    @JvmStatic
    public static final <T> Observable<T> createObservable(RoomDatabase roomDatabase, boolean z, String[] strArr, Function1<? super SQLiteConnection, ? extends T> function1) {
        return Companion.createObservable(roomDatabase, z, strArr, function1);
    }

    @JvmStatic
    public static final Observable<Object> createObservable(RoomDatabase roomDatabase, String... strArr) {
        return Companion.createObservable(roomDatabase, strArr);
    }

    @Deprecated(message = "No longer used by generated code.")
    @JvmStatic
    public static final <T> Observable<T> createObservable(RoomDatabase roomDatabase, String[] strArr, Callable<? extends T> callable) {
        return Companion.createObservable(roomDatabase, strArr, callable);
    }

    @JvmStatic
    public static final <T> Single<T> createSingle(RoomDatabase roomDatabase, boolean z, boolean z2, Function1<? super SQLiteConnection, ? extends T> function1) {
        return Companion.createSingle(roomDatabase, z, z2, function1);
    }

    @JvmStatic
    public static final <T> Single<T> createSingle(Callable<? extends T> callable) {
        return Companion.createSingle(callable);
    }

    /* compiled from: RxRoom.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JQ\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\u0010H\u0007¢\u0006\u0002\u0010\u0012JQ\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0014\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\u0010H\u0007¢\u0006\u0002\u0010\u0015JF\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0017\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\u0010H\u0007J4\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001b0\u0010H\u0007JF\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001d\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\u0010H\u0007J/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u001e\u001a\u00020\t2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0007¢\u0006\u0002\u0010\u001fJC\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070!H\u0007¢\u0006\u0002\u0010\"JK\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070!H\u0007¢\u0006\u0002\u0010#J/\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u001e\u001a\u00020\t2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0007¢\u0006\u0002\u0010$JC\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0014\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070!H\u0007¢\u0006\u0002\u0010%JK\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0014\"\b\b\u0000\u0010\u0007*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070!H\u0007¢\u0006\u0002\u0010&J(\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001d\"\b\b\u0000\u0010\u0007*\u00020\u00012\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070!H\u0007J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/room/RxRoom$Companion;", "", "<init>", "()V", "NOTHING", "createFlowable", "Lio/reactivex/Flowable;", ExifInterface.GPS_DIRECTION_TRUE, "db", "Landroidx/room/RoomDatabase;", "inTransaction", "", "tableNames", "", "", "block", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteConnection;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Flowable;", "createObservable", "Lio/reactivex/Observable;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "createMaybe", "Lio/reactivex/Maybe;", "isReadOnly", "createCompletable", "Lio/reactivex/Completable;", "", "createSingle", "Lio/reactivex/Single;", "database", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;)Lio/reactivex/Flowable;", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lio/reactivex/Flowable;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lio/reactivex/Flowable;", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;)Lio/reactivex/Observable;", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lio/reactivex/Observable;", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lio/reactivex/Observable;", "getExecutor", "Ljava/util/concurrent/Executor;", "room-rxjava2_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final <T> Flowable<T> createFlowable(RoomDatabase db, boolean z, String[] tableNames, Function1<? super SQLiteConnection, ? extends T> block) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(block, "block");
            Flowable<T> flowable = createObservable(db, z, tableNames, block).toFlowable(BackpressureStrategy.LATEST);
            Intrinsics.checkNotNullExpressionValue(flowable, "toFlowable(...)");
            return flowable;
        }

        @JvmStatic
        public final <T> Observable<T> createObservable(RoomDatabase db, boolean z, String[] tableNames, Function1<? super SQLiteConnection, ? extends T> block) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(block, "block");
            return RxConvertKt.asObservable(FlowKt.filterNotNull(FlowUtil.createFlow(db, z, tableNames, block)), db.getQueryContext());
        }

        @JvmStatic
        public final <T> Maybe<T> createMaybe(RoomDatabase db, boolean z, boolean z2, Function1<? super SQLiteConnection, ? extends T> block) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(block, "block");
            return RxMaybeKt.rxMaybe(db.getQueryContext().minusKey(Job.Key), new RxRoom$Companion$createMaybe$1(db, z, z2, block, null));
        }

        @JvmStatic
        public final Completable createCompletable(RoomDatabase db, boolean z, boolean z2, Function1<? super SQLiteConnection, Unit> block) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(block, "block");
            return RxCompletableKt.rxCompletable(db.getQueryContext().minusKey(Job.Key), new RxRoom$Companion$createCompletable$1(db, z, z2, block, null));
        }

        @JvmStatic
        public final <T> Single<T> createSingle(RoomDatabase db, boolean z, boolean z2, Function1<? super SQLiteConnection, ? extends T> block) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(block, "block");
            return RxSingleKt.rxSingle(db.getQueryContext().minusKey(Job.Key), new RxRoom$Companion$createSingle$1(db, z, z2, block, null));
        }

        @JvmStatic
        public final Flowable<Object> createFlowable(final RoomDatabase database, final String... tableNames) {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Flowable<Object> create = Flowable.create(new FlowableOnSubscribe() { // from class: androidx.room.RxRoom$Companion$$ExternalSyntheticLambda6
                @Override // io.reactivex.FlowableOnSubscribe
                public final void subscribe(FlowableEmitter flowableEmitter) {
                    RxRoom.Companion.createFlowable$lambda$1(RoomDatabase.this, tableNames, flowableEmitter);
                }
            }, BackpressureStrategy.LATEST);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.room.RxRoom$Companion$createFlowable$1$observer$1] */
        public static final void createFlowable$lambda$1(final RoomDatabase roomDatabase, final String[] strArr, final FlowableEmitter emitter) {
            Intrinsics.checkNotNullParameter(emitter, "emitter");
            final ?? r0 = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RxRoom$Companion$createFlowable$1$observer$1
                @Override // androidx.room.InvalidationTracker.Observer
                public void onInvalidated(Set<String> tables) {
                    Intrinsics.checkNotNullParameter(tables, "tables");
                    if (emitter.isCancelled()) {
                        return;
                    }
                    emitter.onNext(RxRoom.NOTHING);
                }
            };
            if (!emitter.isCancelled()) {
                roomDatabase.getInvalidationTracker().addObserver((InvalidationTracker.Observer) r0);
                emitter.setDisposable(Disposables.fromAction(new Action() { // from class: androidx.room.RxRoom$Companion$$ExternalSyntheticLambda5
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        RxRoom.Companion.createFlowable$lambda$1$lambda$0(RoomDatabase.this, r0);
                    }
                }));
            }
            if (emitter.isCancelled()) {
                return;
            }
            emitter.onNext(RxRoom.NOTHING);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void createFlowable$lambda$1$lambda$0(RoomDatabase roomDatabase, RxRoom$Companion$createFlowable$1$observer$1 rxRoom$Companion$createFlowable$1$observer$1) {
            roomDatabase.getInvalidationTracker().removeObserver(rxRoom$Companion$createFlowable$1$observer$1);
        }

        @Deprecated(message = "No longer used by generated code.")
        @JvmStatic
        public final <T> Flowable<T> createFlowable(RoomDatabase database, String[] tableNames, Callable<? extends T> callable) {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(callable, "callable");
            return createFlowable(database, false, tableNames, (Callable) callable);
        }

        @Deprecated(message = "No longer used by generated code.")
        @JvmStatic
        public final <T> Flowable<T> createFlowable(RoomDatabase database, boolean z, String[] tableNames, Callable<? extends T> callable) {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(callable, "callable");
            Scheduler from = Schedulers.from(getExecutor(database, z));
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            final Maybe fromCallable = Maybe.fromCallable(callable);
            Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable(...)");
            Flowable<T> flowable = (Flowable<T>) createFlowable(database, (String[]) Arrays.copyOf(tableNames, tableNames.length)).subscribeOn(from).unsubscribeOn(from).observeOn(from).flatMapMaybe(new Function() { // from class: androidx.room.RxRoom$Companion$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    MaybeSource createFlowable$lambda$2;
                    createFlowable$lambda$2 = RxRoom.Companion.createFlowable$lambda$2(Maybe.this, obj);
                    return createFlowable$lambda$2;
                }
            });
            Intrinsics.checkNotNullExpressionValue(flowable, "flatMapMaybe(...)");
            return flowable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MaybeSource createFlowable$lambda$2(Maybe maybe, Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return maybe;
        }

        @JvmStatic
        public final Observable<Object> createObservable(final RoomDatabase database, final String... tableNames) {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Observable<Object> create = Observable.create(new ObservableOnSubscribe() { // from class: androidx.room.RxRoom$Companion$$ExternalSyntheticLambda0
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    RxRoom.Companion.createObservable$lambda$4(RoomDatabase.this, tableNames, observableEmitter);
                }
            });
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.room.RxRoom$Companion$createObservable$1$observer$1] */
        public static final void createObservable$lambda$4(final RoomDatabase roomDatabase, final String[] strArr, final ObservableEmitter emitter) {
            Intrinsics.checkNotNullParameter(emitter, "emitter");
            final ?? r0 = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RxRoom$Companion$createObservable$1$observer$1
                @Override // androidx.room.InvalidationTracker.Observer
                public void onInvalidated(Set<String> tables) {
                    Intrinsics.checkNotNullParameter(tables, "tables");
                    emitter.onNext(RxRoom.NOTHING);
                }
            };
            roomDatabase.getInvalidationTracker().addObserver((InvalidationTracker.Observer) r0);
            emitter.setDisposable(Disposables.fromAction(new Action() { // from class: androidx.room.RxRoom$Companion$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Action
                public final void run() {
                    RxRoom.Companion.createObservable$lambda$4$lambda$3(RoomDatabase.this, r0);
                }
            }));
            emitter.onNext(RxRoom.NOTHING);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void createObservable$lambda$4$lambda$3(RoomDatabase roomDatabase, RxRoom$Companion$createObservable$1$observer$1 rxRoom$Companion$createObservable$1$observer$1) {
            roomDatabase.getInvalidationTracker().removeObserver(rxRoom$Companion$createObservable$1$observer$1);
        }

        @Deprecated(message = "No longer used by generated code.")
        @JvmStatic
        public final <T> Observable<T> createObservable(RoomDatabase database, String[] tableNames, Callable<? extends T> callable) {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(callable, "callable");
            return createObservable(database, false, tableNames, (Callable) callable);
        }

        @Deprecated(message = "No longer used by generated code.")
        @JvmStatic
        public final <T> Observable<T> createObservable(RoomDatabase database, boolean z, String[] tableNames, Callable<? extends T> callable) {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(callable, "callable");
            Scheduler from = Schedulers.from(getExecutor(database, z));
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            final Maybe fromCallable = Maybe.fromCallable(callable);
            Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable(...)");
            Observable<T> observable = (Observable<T>) createObservable(database, (String[]) Arrays.copyOf(tableNames, tableNames.length)).subscribeOn(from).unsubscribeOn(from).observeOn(from).flatMapMaybe(new Function() { // from class: androidx.room.RxRoom$Companion$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    MaybeSource createObservable$lambda$5;
                    createObservable$lambda$5 = RxRoom.Companion.createObservable$lambda$5(Maybe.this, obj);
                    return createObservable$lambda$5;
                }
            });
            Intrinsics.checkNotNullExpressionValue(observable, "flatMapMaybe(...)");
            return observable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MaybeSource createObservable$lambda$5(Maybe maybe, Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return maybe;
        }

        @JvmStatic
        public final <T> Single<T> createSingle(final Callable<? extends T> callable) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            Single<T> create = Single.create(new SingleOnSubscribe() { // from class: androidx.room.RxRoom$Companion$$ExternalSyntheticLambda2
                @Override // io.reactivex.SingleOnSubscribe
                public final void subscribe(SingleEmitter singleEmitter) {
                    RxRoom.Companion.createSingle$lambda$6(callable, singleEmitter);
                }
            });
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void createSingle$lambda$6(Callable callable, SingleEmitter emitter) {
            Intrinsics.checkNotNullParameter(emitter, "emitter");
            try {
                Object call = callable.call();
                if (call != null) {
                    emitter.onSuccess(call);
                    return;
                }
                throw new EmptyResultSetException("Query returned empty result set.");
            } catch (EmptyResultSetException e) {
                emitter.tryOnError(e);
            }
        }

        private final Executor getExecutor(RoomDatabase roomDatabase, boolean z) {
            if (z) {
                return roomDatabase.getTransactionExecutor();
            }
            return roomDatabase.getQueryExecutor();
        }
    }
}
