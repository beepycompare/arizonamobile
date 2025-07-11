package kotlinx.datetime.internal.format;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlinx.datetime.internal.format.parser.AssignableField;
/* compiled from: FieldSpec.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkotlinx/datetime/internal/format/Accessor;", "Object", "Field", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "getter", TtmlNode.RUBY_CONTAINER, "(Ljava/lang/Object;)Ljava/lang/Object;", "getterNotNull", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface Accessor<Object, Field> extends AssignableField<Object, Field> {
    Field getter(Object object);

    /* compiled from: FieldSpec.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <Object, Field> Field getterNotNull(Accessor<? super Object, Field> accessor, Object object) {
            return (Field) Accessor.super.getterNotNull(object);
        }
    }

    default Field getterNotNull(Object object) {
        Field field = getter(object);
        if (field != null) {
            return field;
        }
        throw new IllegalStateException("Field " + getName() + " is not set");
    }
}
