package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int[] EMPTY_STATE_SET = new int[0];
    public static final Rect INSETS_NONE = new Rect();

    @Deprecated
    public static boolean canSafelyMutateDrawable(Drawable drawable) {
        return true;
    }

    private DrawableUtils() {
    }

    public static Rect getOpticalBounds(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 29) {
            Insets opticalInsets = Api29Impl.getOpticalInsets(drawable);
            return new Rect(opticalInsets.left, opticalInsets.top, opticalInsets.right, opticalInsets.bottom);
        }
        return Api18Impl.getOpticalInsets(DrawableCompat.unwrap(drawable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fixDrawable(Drawable drawable) {
        String name = drawable.getClass().getName();
        if (Build.VERSION.SDK_INT < 29 || Build.VERSION.SDK_INT >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        forceDrawableStateChange(drawable);
    }

    private static void forceDrawableStateChange(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(CHECKED_STATE_SET);
        } else {
            drawable.setState(EMPTY_STATE_SET);
        }
        drawable.setState(state);
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i == 9) {
                    return PorterDuff.Mode.SRC_ATOP;
                }
                switch (i) {
                    case 14:
                        return PorterDuff.Mode.MULTIPLY;
                    case 15:
                        return PorterDuff.Mode.SCREEN;
                    case 16:
                        return PorterDuff.Mode.ADD;
                    default:
                        return mode;
                }
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* loaded from: classes.dex */
    static class Api18Impl {
        private static final Field sBottom;
        private static final Method sGetOpticalInsets;
        private static final Field sLeft;
        private static final boolean sReflectionSuccessful;
        private static final Field sRight;
        private static final Field sTop;

        /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
        static {
            Method method;
            Field field;
            Field field2;
            Field field3;
            Field field4;
            boolean z;
            try {
                Class<?> cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", new Class[0]);
                try {
                    field = cls.getField(TtmlNode.LEFT);
                } catch (ClassNotFoundException unused) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (NoSuchFieldException unused2) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (NoSuchMethodException unused3) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                }
                try {
                    field2 = cls.getField("top");
                    try {
                        field3 = cls.getField(TtmlNode.RIGHT);
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused4) {
                        field3 = null;
                    }
                    try {
                        field4 = cls.getField("bottom");
                        z = true;
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused5) {
                        field4 = null;
                        z = false;
                        if (!z) {
                        }
                    }
                } catch (ClassNotFoundException unused6) {
                    field2 = null;
                    field3 = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (NoSuchFieldException unused7) {
                    field2 = null;
                    field3 = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (NoSuchMethodException unused8) {
                    field2 = null;
                    field3 = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                }
            } catch (ClassNotFoundException unused9) {
                method = null;
                field = null;
            } catch (NoSuchFieldException unused10) {
                method = null;
                field = null;
            } catch (NoSuchMethodException unused11) {
                method = null;
                field = null;
            }
            if (!z) {
                sGetOpticalInsets = method;
                sLeft = field;
                sTop = field2;
                sRight = field3;
                sBottom = field4;
                sReflectionSuccessful = true;
                return;
            }
            sGetOpticalInsets = null;
            sLeft = null;
            sTop = null;
            sRight = null;
            sBottom = null;
            sReflectionSuccessful = false;
        }

        private Api18Impl() {
        }

        static Rect getOpticalInsets(Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && sReflectionSuccessful) {
                try {
                    Object invoke = sGetOpticalInsets.invoke(drawable, new Object[0]);
                    if (invoke != null) {
                        return new Rect(sLeft.getInt(invoke), sTop.getInt(invoke), sRight.getInt(invoke), sBottom.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return DrawableUtils.INSETS_NONE;
        }
    }

    /* loaded from: classes.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static Insets getOpticalInsets(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }
}
