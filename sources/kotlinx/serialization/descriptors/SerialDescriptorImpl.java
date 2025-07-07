package kotlinx.serialization.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;
/* compiled from: SerialDescriptors.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u0004H\u0016J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u0002042\u0006\u0010.\u001a\u00020\bH\u0016J\u0013\u00105\u001a\u0002042\b\u00106\u001a\u0004\u0018\u000107H\u0096\u0002J\b\u00108\u001a\u00020\bH\u0016J\b\u00109\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\n0\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001b\u0010)\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b*\u0010\u0014¨\u0006:"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", "", "typeParameters", "", "builder", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "getSerialName", "()Ljava/lang/String;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getElementsCount", "()I", "annotations", "", "getAnnotations", "()Ljava/util/List;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "elementNames", "", "[Ljava/lang/String;", "elementDescriptors", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementAnnotations", "[Ljava/util/List;", "elementOptionality", "", "name2Index", "", "typeParametersDescriptors", "_hashCode", "get_hashCode", "_hashCode$delegate", "Lkotlin/Lazy;", "getElementName", FirebaseAnalytics.Param.INDEX, "getElementIndex", "name", "getElementAnnotations", "getElementDescriptor", "isElementOptional", "", "equals", "other", "", "hashCode", "toString", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {
    private final Lazy _hashCode$delegate;
    private final List<Annotation> annotations;
    private final List<Annotation>[] elementAnnotations;
    private final SerialDescriptor[] elementDescriptors;
    private final String[] elementNames;
    private final boolean[] elementOptionality;
    private final int elementsCount;
    private final SerialKind kind;
    private final Map<String, Integer> name2Index;
    private final String serialName;
    private final Set<String> serialNames;
    private final SerialDescriptor[] typeParametersDescriptors;

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.isInline(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return SerialDescriptor.DefaultImpls.isNullable(this);
    }

    public SerialDescriptorImpl(String serialName, SerialKind kind, int i, List<? extends SerialDescriptor> typeParameters, ClassSerialDescriptorBuilder builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.serialName = serialName;
        this.kind = kind;
        this.elementsCount = i;
        this.annotations = builder.getAnnotations();
        this.serialNames = CollectionsKt.toHashSet(builder.getElementNames$kotlinx_serialization_core());
        String[] strArr = (String[]) builder.getElementNames$kotlinx_serialization_core().toArray(new String[0]);
        this.elementNames = strArr;
        this.elementDescriptors = Platform_commonKt.compactArray(builder.getElementDescriptors$kotlinx_serialization_core());
        this.elementAnnotations = (List[]) builder.getElementAnnotations$kotlinx_serialization_core().toArray(new List[0]);
        this.elementOptionality = CollectionsKt.toBooleanArray(builder.getElementOptionality$kotlinx_serialization_core());
        Iterable<IndexedValue> withIndex = ArraysKt.withIndex(strArr);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(withIndex, 10));
        for (IndexedValue indexedValue : withIndex) {
            arrayList.add(TuplesKt.to(indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex())));
        }
        this.name2Index = MapsKt.toMap(arrayList);
        this.typeParametersDescriptors = Platform_commonKt.compactArray(typeParameters);
        this._hashCode$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int _hashCode_delegate$lambda$1;
                _hashCode_delegate$lambda$1 = SerialDescriptorImpl._hashCode_delegate$lambda$1(SerialDescriptorImpl.this);
                return Integer.valueOf(_hashCode_delegate$lambda$1);
            }
        });
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _hashCode_delegate$lambda$1(SerialDescriptorImpl serialDescriptorImpl) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl(serialDescriptorImpl, serialDescriptorImpl.typeParametersDescriptors);
    }

    private final int get_hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int i) {
        return this.elementNames[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = this.name2Index.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getElementAnnotations(int i) {
        return this.elementAnnotations[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int i) {
        return this.elementDescriptors[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int i) {
        return this.elementOptionality[i];
    }

    public boolean equals(Object obj) {
        SerialDescriptorImpl serialDescriptorImpl = this;
        if (serialDescriptorImpl == obj) {
            return true;
        }
        if (obj instanceof SerialDescriptorImpl) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.areEqual(serialDescriptorImpl.getSerialName(), serialDescriptor.getSerialName()) && Arrays.equals(this.typeParametersDescriptors, ((SerialDescriptorImpl) obj).typeParametersDescriptors) && serialDescriptorImpl.getElementsCount() == serialDescriptor.getElementsCount()) {
                int elementsCount = serialDescriptorImpl.getElementsCount();
                for (int i = 0; i < elementsCount; i++) {
                    if (!Intrinsics.areEqual(serialDescriptorImpl.getElementDescriptor(i).getSerialName(), serialDescriptor.getElementDescriptor(i).getSerialName()) || !Intrinsics.areEqual(serialDescriptorImpl.getElementDescriptor(i).getKind(), serialDescriptor.getElementDescriptor(i).getKind())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return get_hashCode();
    }

    public String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, getElementsCount()), ", ", getSerialName() + '(', ")", 0, null, new Function1() { // from class: kotlinx.serialization.descriptors.SerialDescriptorImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence string$lambda$3;
                string$lambda$3 = SerialDescriptorImpl.toString$lambda$3(SerialDescriptorImpl.this, ((Integer) obj).intValue());
                return string$lambda$3;
            }
        }, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toString$lambda$3(SerialDescriptorImpl serialDescriptorImpl, int i) {
        return serialDescriptorImpl.getElementName(i) + ": " + serialDescriptorImpl.getElementDescriptor(i).getSerialName();
    }
}
