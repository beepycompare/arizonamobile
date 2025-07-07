package com.arkivanov.decompose.router.panels;

import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.router.webhistory.WebNavigation;
import com.arkivanov.decompose.router.webhistory.WebNavigationOwner;
import com.arkivanov.decompose.value.Value;
import com.arkivanov.decompose.value.operator.MapKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PanelsWebNavigation.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u0002*\n\b\u0003\u0010\u0005 \u0001*\u00020\u0002*\b\b\u0004\u0010\u0006*\u00020\u0002*\n\b\u0005\u0010\u0007 \u0001*\u00020\u00022\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00060\t0\b:\u0001)BÅ\u0002\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\u000b\u00120\u0010\f\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000e0\r\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u0010\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00040\u0010\u00128\u0010\u0013\u001a4\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014\u0012D\u0010\u0016\u001a@\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00170\u0014\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00128\u0010\u001b\u001a4\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0018\u001a\u00020\u001aH\u0016J(\u0010'\u001a\u00020(2\u001e\u0010\"\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\t0#H\u0016R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0013\u001a4\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000RL\u0010\u0016\u001a@\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u001b\u001a4\u0012(\u0012&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\t0\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R8\u0010\"\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00040\t0$0#0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/arkivanov/decompose/router/panels/PanelsWebNavigation;", "MC", "", "MT", "DC", "DT", "EC", "ET", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", "Lcom/arkivanov/decompose/router/panels/PanelsWebNavigation$HistoryItemKey;", "navigator", "Lcom/arkivanov/decompose/router/panels/PanelsNavigator;", "panels", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/panels/ChildPanels;", "mainSerializer", "Lkotlinx/serialization/KSerializer;", "detailsSerializer", "extraSerializer", "pathMapper", "Lkotlin/Function1;", "", "parametersMapper", "", "onBeforeNavigate", "Lkotlin/Function0;", "", "childSelector", "Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner;", "<init>", "(Lcom/arkivanov/decompose/router/panels/PanelsNavigator;Lcom/arkivanov/decompose/value/Value;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "serializer", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "history", "", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation$HistoryItem;", "getHistory", "()Lcom/arkivanov/decompose/value/Value;", "navigate", "", "HistoryItemKey", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PanelsWebNavigation<MC, MT, DC, DT, EC, ET> implements WebNavigation<HistoryItemKey<? extends MC, ? extends DC, ? extends EC>> {
    private final Function1<ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>, WebNavigationOwner> childSelector;
    private final Value<List<WebNavigation.HistoryItem<HistoryItemKey<MC, DC, EC>>>> history;
    private final PanelsNavigator<MC, DC, EC> navigator;
    private final Function0<Boolean> onBeforeNavigate;
    private final Function1<ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>, Map<String, String>> parametersMapper;
    private final Function1<ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>, String> pathMapper;
    private final KSerializer<HistoryItemKey<MC, DC, EC>> serializer;

    /* JADX WARN: Multi-variable type inference failed */
    public PanelsWebNavigation(PanelsNavigator<MC, DC, EC> navigator, Value<? extends ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>> panels, KSerializer<MC> mainSerializer, KSerializer<DC> detailsSerializer, KSerializer<EC> extraSerializer, Function1<? super ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>, String> pathMapper, Function1<? super ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>, ? extends Map<String, String>> parametersMapper, Function0<Boolean> onBeforeNavigate, Function1<? super ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>, ? extends WebNavigationOwner> childSelector) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(panels, "panels");
        Intrinsics.checkNotNullParameter(mainSerializer, "mainSerializer");
        Intrinsics.checkNotNullParameter(detailsSerializer, "detailsSerializer");
        Intrinsics.checkNotNullParameter(extraSerializer, "extraSerializer");
        Intrinsics.checkNotNullParameter(pathMapper, "pathMapper");
        Intrinsics.checkNotNullParameter(parametersMapper, "parametersMapper");
        Intrinsics.checkNotNullParameter(onBeforeNavigate, "onBeforeNavigate");
        Intrinsics.checkNotNullParameter(childSelector, "childSelector");
        this.navigator = navigator;
        this.pathMapper = pathMapper;
        this.parametersMapper = parametersMapper;
        this.onBeforeNavigate = onBeforeNavigate;
        this.childSelector = childSelector;
        this.serializer = HistoryItemKey.Companion.serializer(mainSerializer, detailsSerializer, extraSerializer);
        this.history = MapKt.map(panels, new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsWebNavigation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List history$lambda$0;
                history$lambda$0 = PanelsWebNavigation.history$lambda$0(PanelsWebNavigation.this, (ChildPanels) obj);
                return history$lambda$0;
            }
        });
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public KSerializer<HistoryItemKey<MC, DC, EC>> getSerializer() {
        return this.serializer;
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public Value<List<WebNavigation.HistoryItem<HistoryItemKey<MC, DC, EC>>>> getHistory() {
        return this.history;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List history$lambda$0(PanelsWebNavigation panelsWebNavigation, ChildPanels panels) {
        Intrinsics.checkNotNullParameter(panels, "panels");
        String invoke = panelsWebNavigation.pathMapper.invoke(panels);
        if (invoke == null) {
            invoke = "";
        }
        Map<String, String> invoke2 = panelsWebNavigation.parametersMapper.invoke(panels);
        if (invoke2 == null) {
            invoke2 = MapsKt.emptyMap();
        }
        MC configuration = panels.getMain().getConfiguration();
        Child.Created<EC, ET> extra = panels.getExtra();
        EC configuration2 = extra != null ? extra.getConfiguration() : null;
        Child.Created<DC, DT> details = panels.getDetails();
        return CollectionsKt.listOf(new WebNavigation.HistoryItem(new HistoryItemKey(configuration, details != null ? details.getConfiguration() : null, configuration2), invoke, invoke2, panelsWebNavigation.childSelector.invoke(panels)));
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public boolean onBeforeNavigate() {
        return this.onBeforeNavigate.invoke().booleanValue();
    }

    @Override // com.arkivanov.decompose.router.webhistory.WebNavigation
    public void navigate(List<? extends HistoryItemKey<? extends MC, ? extends DC, ? extends EC>> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        HistoryItemKey historyItemKey = (HistoryItemKey) CollectionsKt.single((List<? extends Object>) history);
        PanelsNavigatorExtKt.navigate$default(this.navigator, historyItemKey.getMain(), historyItemKey.getDetails(), historyItemKey.getExtra(), null, 8, null);
    }

    /* compiled from: PanelsWebNavigation.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 ,*\n\b\u0006\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0007\u0010\u0003 \u0001*\u00020\u0002*\n\b\b\u0010\u0004 \u0001*\u00020\u00022\u00020\u0002:\u0002+,B#\u0012\u0006\u0010\u0005\u001a\u00028\u0006\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0007\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\b¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0006\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0007\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000e\u0010\u0014\u001a\u00028\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00018\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0016\u001a\u0004\u0018\u00018\bHÆ\u0003¢\u0006\u0002\u0010\u0010JB\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b0\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00062\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u00072\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0085\u0001\u0010\u001f\u001a\u00020 \"\n\b\t\u0010\u0001*\u0004\u0018\u00010\u0002\"\n\b\n\u0010\u0003*\u0004\u0018\u00010\u0002\"\n\b\u000b\u0010\u0004*\u0004\u0018\u00010\u00022\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00030'2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00040'H\u0001¢\u0006\u0002\b*R\u0013\u0010\u0005\u001a\u00028\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00018\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010¨\u0006-"}, d2 = {"Lcom/arkivanov/decompose/router/panels/PanelsWebNavigation$HistoryItemKey;", "MC", "", "DC", "EC", JvmProtoBufUtil.DEFAULT_MODULE_NAME, "details", "extra", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMain", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDetails", "getExtra", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/arkivanov/decompose/router/panels/PanelsWebNavigation$HistoryItemKey;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "typeSerial1", "typeSerial2", "write$Self$decompose_release", "$serializer", "Companion", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes3.dex */
    public static final class HistoryItemKey<MC, DC, EC> {
        private static final SerialDescriptor $cachedDescriptor;
        public static final Companion Companion = new Companion(null);
        private final DC details;
        private final EC extra;
        private final MC main;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HistoryItemKey copy$default(HistoryItemKey historyItemKey, Object obj, Object obj2, Object obj3, int i, Object obj4) {
            if ((i & 1) != 0) {
                obj = historyItemKey.main;
            }
            if ((i & 2) != 0) {
                obj2 = historyItemKey.details;
            }
            if ((i & 4) != 0) {
                obj3 = historyItemKey.extra;
            }
            return historyItemKey.copy(obj, obj2, obj3);
        }

        public final MC component1() {
            return this.main;
        }

        public final DC component2() {
            return this.details;
        }

        public final EC component3() {
            return this.extra;
        }

        public final HistoryItemKey<MC, DC, EC> copy(MC main, DC dc, EC ec) {
            Intrinsics.checkNotNullParameter(main, "main");
            return new HistoryItemKey<>(main, dc, ec);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HistoryItemKey) {
                HistoryItemKey historyItemKey = (HistoryItemKey) obj;
                return Intrinsics.areEqual(this.main, historyItemKey.main) && Intrinsics.areEqual(this.details, historyItemKey.details) && Intrinsics.areEqual(this.extra, historyItemKey.extra);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.main.hashCode() * 31;
            DC dc = this.details;
            int hashCode2 = (hashCode + (dc == null ? 0 : dc.hashCode())) * 31;
            EC ec = this.extra;
            return hashCode2 + (ec != null ? ec.hashCode() : 0);
        }

        public String toString() {
            return "HistoryItemKey(main=" + this.main + ", details=" + this.details + ", extra=" + this.extra + ')';
        }

        /* compiled from: PanelsWebNavigation.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JZ\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u00060\u0005\"\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005¨\u0006\r"}, d2 = {"Lcom/arkivanov/decompose/router/panels/PanelsWebNavigation$HistoryItemKey$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/arkivanov/decompose/router/panels/PanelsWebNavigation$HistoryItemKey;", "MC", "DC", "EC", "typeSerial0", "typeSerial1", "typeSerial2", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final <MC, DC, EC> KSerializer<HistoryItemKey<MC, DC, EC>> serializer(KSerializer<MC> typeSerial0, KSerializer<DC> typeSerial1, KSerializer<EC> typeSerial2) {
                Intrinsics.checkNotNullParameter(typeSerial0, "typeSerial0");
                Intrinsics.checkNotNullParameter(typeSerial1, "typeSerial1");
                Intrinsics.checkNotNullParameter(typeSerial2, "typeSerial2");
                return new PanelsWebNavigation$HistoryItemKey$$serializer(typeSerial0, typeSerial1, typeSerial2);
            }
        }

        static {
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.arkivanov.decompose.router.panels.PanelsWebNavigation.HistoryItemKey", null, 3);
            pluginGeneratedSerialDescriptor.addElement(JvmProtoBufUtil.DEFAULT_MODULE_NAME, false);
            pluginGeneratedSerialDescriptor.addElement("details", false);
            pluginGeneratedSerialDescriptor.addElement("extra", false);
            $cachedDescriptor = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ HistoryItemKey(int i, Object obj, Object obj2, Object obj3, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, $cachedDescriptor);
            }
            this.main = obj;
            this.details = obj2;
            this.extra = obj3;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$decompose_release(HistoryItemKey historyItemKey, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor, KSerializer kSerializer, KSerializer kSerializer2, KSerializer kSerializer3) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, kSerializer, historyItemKey.main);
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, kSerializer2, historyItemKey.details);
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, kSerializer3, historyItemKey.extra);
        }

        public HistoryItemKey(MC main, DC dc, EC ec) {
            Intrinsics.checkNotNullParameter(main, "main");
            this.main = main;
            this.details = dc;
            this.extra = ec;
        }

        public final MC getMain() {
            return this.main;
        }

        public final DC getDetails() {
            return this.details;
        }

        public final EC getExtra() {
            return this.extra;
        }
    }
}
