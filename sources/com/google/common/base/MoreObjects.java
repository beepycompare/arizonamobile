package com.google.common.base;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class MoreObjects {
    public static <T> T firstNonNull(@CheckForNull T first, @CheckForNull T second) {
        if (first != null) {
            return first;
        }
        if (second != null) {
            return second;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Object self) {
        return new ToStringHelper(self.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> clazz) {
        return new ToStringHelper(clazz.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String className) {
        return new ToStringHelper(className);
    }

    /* loaded from: classes4.dex */
    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitEmptyValues;
        private boolean omitNullValues;

        private ToStringHelper(String className) {
            ValueHolder valueHolder = new ValueHolder();
            this.holderHead = valueHolder;
            this.holderTail = valueHolder;
            this.omitNullValues = false;
            this.omitEmptyValues = false;
            this.className = (String) Preconditions.checkNotNull(className);
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public ToStringHelper add(String name, @CheckForNull Object value) {
            return addHolder(name, value);
        }

        public ToStringHelper add(String name, boolean value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper add(String name, char value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper add(String name, double value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper add(String name, float value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper add(String name, int value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper add(String name, long value) {
            return addUnconditionalHolder(name, String.valueOf(value));
        }

        public ToStringHelper addValue(@CheckForNull Object value) {
            return addHolder(value);
        }

        public ToStringHelper addValue(boolean value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        public ToStringHelper addValue(char value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        public ToStringHelper addValue(double value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        public ToStringHelper addValue(float value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        public ToStringHelper addValue(int value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        public ToStringHelper addValue(long value) {
            return addUnconditionalHolder(String.valueOf(value));
        }

        private static boolean isEmpty(Object value) {
            if (value instanceof CharSequence) {
                return ((CharSequence) value).length() == 0;
            } else if (value instanceof Collection) {
                return ((Collection) value).isEmpty();
            } else {
                if (value instanceof Map) {
                    return ((Map) value).isEmpty();
                }
                if (value instanceof Optional) {
                    return !((Optional) value).isPresent();
                }
                return value.getClass().isArray() && Array.getLength(value) == 0;
            }
        }

        public String toString() {
            boolean z = this.omitNullValues;
            boolean z2 = this.omitEmptyValues;
            StringBuilder append = new StringBuilder(32).append(this.className).append(AbstractJsonLexerKt.BEGIN_OBJ);
            String str = "";
            for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                Object obj = valueHolder.value;
                if (!(valueHolder instanceof UnconditionalValueHolder)) {
                    if (obj == null) {
                        if (z) {
                        }
                    } else if (z2 && isEmpty(obj)) {
                    }
                }
                append.append(str);
                if (valueHolder.name != null) {
                    append.append(valueHolder.name).append('=');
                }
                if (obj != null && obj.getClass().isArray()) {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    append.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                } else {
                    append.append(obj);
                }
                str = ", ";
            }
            return append.append(AbstractJsonLexerKt.END_OBJ).toString();
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder = new ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        private ToStringHelper addHolder(@CheckForNull Object value) {
            addHolder().value = value;
            return this;
        }

        private ToStringHelper addHolder(String name, @CheckForNull Object value) {
            ValueHolder addHolder = addHolder();
            addHolder.value = value;
            addHolder.name = (String) Preconditions.checkNotNull(name);
            return this;
        }

        private UnconditionalValueHolder addUnconditionalHolder() {
            UnconditionalValueHolder unconditionalValueHolder = new UnconditionalValueHolder();
            this.holderTail.next = unconditionalValueHolder;
            this.holderTail = unconditionalValueHolder;
            return unconditionalValueHolder;
        }

        private ToStringHelper addUnconditionalHolder(Object value) {
            addUnconditionalHolder().value = value;
            return this;
        }

        private ToStringHelper addUnconditionalHolder(String name, Object value) {
            UnconditionalValueHolder addUnconditionalHolder = addUnconditionalHolder();
            addUnconditionalHolder.value = value;
            addUnconditionalHolder.name = (String) Preconditions.checkNotNull(name);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static class ValueHolder {
            @CheckForNull
            String name;
            @CheckForNull
            ValueHolder next;
            @CheckForNull
            Object value;

            ValueHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes4.dex */
        public static final class UnconditionalValueHolder extends ValueHolder {
            private UnconditionalValueHolder() {
            }
        }
    }

    private MoreObjects() {
    }
}
