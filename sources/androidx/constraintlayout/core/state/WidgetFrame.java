package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.reactivex.annotations.SchedulerSupport;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes2.dex */
public class WidgetFrame {
    public static float phone_orientation = Float.NaN;
    public float alpha;
    public int bottom;
    public float interpolatedPos;
    public int left;
    private final HashMap<String, CustomVariable> mCustom;
    TypedBundle mMotionProperties;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = constraintWidget;
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.mCustom = new HashMap<>();
        this.name = null;
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        if (widgetFrame == null) {
            return;
        }
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        setMotionAttributes(widgetFrame.mMotionProperties);
        this.mCustom.clear();
        for (CustomVariable customVariable : widgetFrame.mCustom.values()) {
            this.mCustom.put(customVariable.getName(), customVariable.copy());
        }
    }

    public boolean isDefaultTransform() {
        return Float.isNaN(this.rotationX) && Float.isNaN(this.rotationY) && Float.isNaN(this.rotationZ) && Float.isNaN(this.translationX) && Float.isNaN(this.translationY) && Float.isNaN(this.translationZ) && Float.isNaN(this.scaleX) && Float.isNaN(this.scaleY) && Float.isNaN(this.alpha);
    }

    public static void interpolate(int i, int i2, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f) {
        int i3;
        int i4;
        int i5;
        float f2;
        int i6;
        float f3;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f4 = 100.0f * f;
        int i14 = (int) f4;
        int i15 = widgetFrame2.left;
        int i16 = widgetFrame2.top;
        int i17 = widgetFrame3.left;
        int i18 = widgetFrame3.top;
        int i19 = widgetFrame2.right - i15;
        int i20 = widgetFrame2.bottom - i16;
        int i21 = widgetFrame3.right - i17;
        int i22 = widgetFrame3.bottom - i18;
        int i23 = i15;
        float f5 = widgetFrame2.alpha;
        float f6 = widgetFrame3.alpha;
        if (widgetFrame2.visibility == 8) {
            int i24 = i23 - ((int) (i21 / 2.0f));
            i5 = i16 - ((int) (i22 / 2.0f));
            if (Float.isNaN(f5)) {
                i3 = i22;
                i23 = i24;
                i4 = i21;
                f2 = 0.0f;
            } else {
                i23 = i24;
                i4 = i21;
                f2 = f5;
                i3 = i22;
            }
        } else {
            i3 = i22;
            i22 = i20;
            i4 = i19;
            i5 = i16;
            f2 = f5;
        }
        if (widgetFrame3.visibility == 8) {
            i17 -= (int) (i4 / 2.0f);
            i18 -= (int) (i22 / 2.0f);
            if (Float.isNaN(f6)) {
                i6 = i22;
                i21 = i4;
                f6 = 0.0f;
            } else {
                i6 = i22;
                i21 = i4;
            }
        } else {
            i6 = i3;
        }
        if (Float.isNaN(f2) && !Float.isNaN(f6)) {
            f2 = 1.0f;
        }
        if (!Float.isNaN(f2) && Float.isNaN(f6)) {
            f6 = 1.0f;
        }
        int i25 = i17;
        float f7 = widgetFrame2.visibility == 4 ? 0.0f : f2;
        int i26 = i18;
        float f8 = widgetFrame3.visibility == 4 ? 0.0f : f6;
        if (widgetFrame.widget == null || !transition.hasPositionKeyframes()) {
            f3 = f;
            i7 = i25;
            i8 = i26;
            i9 = i5;
        } else {
            Transition.KeyPosition findPreviousPosition = transition.findPreviousPosition(widgetFrame.widget.stringId, i14);
            int i27 = i5;
            Transition.KeyPosition findNextPosition = transition.findNextPosition(widgetFrame.widget.stringId, i14);
            if (findPreviousPosition == findNextPosition) {
                findNextPosition = null;
            }
            if (findPreviousPosition != null) {
                i23 = (int) (findPreviousPosition.mX * i);
                i11 = findPreviousPosition.mFrame;
                i9 = (int) (findPreviousPosition.mY * i2);
            } else {
                i11 = 0;
                i9 = i27;
            }
            if (findNextPosition != null) {
                i7 = (int) (findNextPosition.mX * i);
                i13 = (int) (findNextPosition.mY * i2);
                i12 = findNextPosition.mFrame;
            } else {
                i12 = 100;
                i7 = i25;
                i13 = i26;
            }
            f3 = (f4 - i11) / (i12 - i11);
            i8 = i13;
        }
        widgetFrame.widget = widgetFrame2.widget;
        int i28 = (int) (i23 + ((i7 - i10) * f3));
        widgetFrame.left = i28;
        int i29 = (int) (i9 + (f3 * (i8 - i9)));
        widgetFrame.top = i29;
        float f9 = 1.0f - f;
        widgetFrame.right = i28 + ((int) ((i4 * f9) + (i21 * f)));
        widgetFrame.bottom = i29 + ((int) ((f9 * i22) + (i6 * f)));
        widgetFrame.pivotX = interpolate(widgetFrame2.pivotX, widgetFrame3.pivotX, 0.5f, f);
        widgetFrame.pivotY = interpolate(widgetFrame2.pivotY, widgetFrame3.pivotY, 0.5f, f);
        widgetFrame.rotationX = interpolate(widgetFrame2.rotationX, widgetFrame3.rotationX, 0.0f, f);
        widgetFrame.rotationY = interpolate(widgetFrame2.rotationY, widgetFrame3.rotationY, 0.0f, f);
        widgetFrame.rotationZ = interpolate(widgetFrame2.rotationZ, widgetFrame3.rotationZ, 0.0f, f);
        widgetFrame.scaleX = interpolate(widgetFrame2.scaleX, widgetFrame3.scaleX, 1.0f, f);
        widgetFrame.scaleY = interpolate(widgetFrame2.scaleY, widgetFrame3.scaleY, 1.0f, f);
        widgetFrame.translationX = interpolate(widgetFrame2.translationX, widgetFrame3.translationX, 0.0f, f);
        widgetFrame.translationY = interpolate(widgetFrame2.translationY, widgetFrame3.translationY, 0.0f, f);
        widgetFrame.translationZ = interpolate(widgetFrame2.translationZ, widgetFrame3.translationZ, 0.0f, f);
        widgetFrame.alpha = interpolate(f7, f8, 1.0f, f);
        Set<String> keySet = widgetFrame3.mCustom.keySet();
        widgetFrame.mCustom.clear();
        for (String str : keySet) {
            if (widgetFrame2.mCustom.containsKey(str)) {
                CustomVariable customVariable = widgetFrame2.mCustom.get(str);
                CustomVariable customVariable2 = widgetFrame3.mCustom.get(str);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                widgetFrame.mCustom.put(str, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    customVariable3.setValue(Float.valueOf(interpolate(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), 0.0f, f)));
                } else {
                    int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[numberOfInterpolatedValues];
                    float[] fArr2 = new float[numberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    for (int i30 = 0; i30 < numberOfInterpolatedValues; i30++) {
                        fArr[i30] = interpolate(fArr[i30], fArr2[i30], 0.0f, f);
                        customVariable3.setValue(fArr);
                    }
                }
            }
        }
    }

    private static float interpolate(float f, float f2, float f3, float f4) {
        boolean isNaN = Float.isNaN(f);
        boolean isNaN2 = Float.isNaN(f2);
        if (isNaN && isNaN2) {
            return Float.NaN;
        }
        if (isNaN) {
            f = f3;
        }
        if (isNaN2) {
            f2 = f3;
        }
        return f + (f4 * (f2 - f));
    }

    public float centerX() {
        int i = this.left;
        return i + ((this.right - i) / 2.0f);
    }

    public float centerY() {
        int i = this.top;
        return i + ((this.bottom - i) / 2.0f);
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public boolean containsCustom(String str) {
        return this.mCustom.containsKey(str);
    }

    public void addCustomColor(String str, int i) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_COLOR, i);
    }

    public int getCustomColor(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getColorValue();
        }
        return -21880;
    }

    public void addCustomFloat(String str, float f) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_FLOAT, f);
    }

    public float getCustomFloat(String str) {
        if (this.mCustom.containsKey(str)) {
            return this.mCustom.get(str).getFloatValue();
        }
        return Float.NaN;
    }

    public void setCustomAttribute(String str, int i, float f) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setFloatValue(f);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, f));
        }
    }

    public void setCustomAttribute(String str, int i, int i2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setIntValue(i2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, i2));
        }
    }

    public void setCustomAttribute(String str, int i, boolean z) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setBooleanValue(z);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, z));
        }
    }

    public void setCustomAttribute(String str, int i, String str2) {
        if (this.mCustom.containsKey(str)) {
            this.mCustom.get(str).setStringValue(str2);
        } else {
            this.mCustom.put(str, new CustomVariable(str, i, str2));
        }
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.mCustom.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.mCustom.keySet();
    }

    public boolean setValue(String str, CLElement cLElement) throws CLParsingException {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1881940865:
                if (str.equals("phone_orientation")) {
                    c = 0;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    c = 1;
                    break;
                }
                break;
            case -1349088399:
                if (str.equals(SchedulerSupport.CUSTOM)) {
                    c = 2;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 3;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 4;
                    break;
                }
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c = 5;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 6;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 7;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = '\b';
                    break;
                }
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c = '\t';
                    break;
                }
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c = '\n';
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 11;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = '\f';
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c = '\r';
                    break;
                }
                break;
            case 3317767:
                if (str.equals(TtmlNode.LEFT)) {
                    c = 14;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 15;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(TtmlNode.RIGHT)) {
                    c = 16;
                    break;
                }
                break;
            case 642850769:
                if (str.equals("interpolatedPos")) {
                    c = 17;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                phone_orientation = cLElement.getFloat();
                break;
            case 1:
                this.bottom = cLElement.getInt();
                break;
            case 2:
                parseCustom(cLElement);
                break;
            case 3:
                this.rotationX = cLElement.getFloat();
                break;
            case 4:
                this.rotationY = cLElement.getFloat();
                break;
            case 5:
                this.rotationZ = cLElement.getFloat();
                break;
            case 6:
                this.translationX = cLElement.getFloat();
                break;
            case 7:
                this.translationY = cLElement.getFloat();
                break;
            case '\b':
                this.translationZ = cLElement.getFloat();
                break;
            case '\t':
                this.pivotX = cLElement.getFloat();
                break;
            case '\n':
                this.pivotY = cLElement.getFloat();
                break;
            case 11:
                this.scaleX = cLElement.getFloat();
                break;
            case '\f':
                this.scaleY = cLElement.getFloat();
                break;
            case '\r':
                this.top = cLElement.getInt();
                break;
            case 14:
                this.left = cLElement.getInt();
                break;
            case 15:
                this.alpha = cLElement.getFloat();
                break;
            case 16:
                this.right = cLElement.getInt();
                break;
            case 17:
                this.interpolatedPos = cLElement.getFloat();
                break;
            default:
                return false;
        }
        return true;
    }

    public String getId() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget == null) {
            return "unknown";
        }
        return constraintWidget.stringId;
    }

    void parseCustom(CLElement cLElement) throws CLParsingException {
        CLObject cLObject = (CLObject) cLElement;
        int size = cLObject.size();
        for (int i = 0; i < size; i++) {
            CLElement value = ((CLKey) cLObject.get(i)).getValue();
            String content = value.content();
            if (content.matches("#[0-9a-fA-F]+")) {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_COLOR, Integer.parseInt(content.substring(1), 16));
            } else if (value instanceof CLNumber) {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_FLOAT, value.getFloat());
            } else {
                setCustomAttribute(this.name, TypedValues.Custom.TYPE_STRING, content);
            }
        }
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    public StringBuilder serialize(StringBuilder sb, boolean z) {
        sb.append("{\n");
        add(sb, TtmlNode.LEFT, this.left);
        add(sb, "top", this.top);
        add(sb, TtmlNode.RIGHT, this.right);
        add(sb, "bottom", this.bottom);
        add(sb, "pivotX", this.pivotX);
        add(sb, "pivotY", this.pivotY);
        add(sb, "rotationX", this.rotationX);
        add(sb, "rotationY", this.rotationY);
        add(sb, "rotationZ", this.rotationZ);
        add(sb, "translationX", this.translationX);
        add(sb, "translationY", this.translationY);
        add(sb, "translationZ", this.translationZ);
        add(sb, "scaleX", this.scaleX);
        add(sb, "scaleY", this.scaleY);
        add(sb, "alpha", this.alpha);
        add(sb, "visibility", this.visibility);
        add(sb, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            for (ConstraintAnchor.Type type : ConstraintAnchor.Type.values()) {
                serializeAnchor(sb, type);
            }
        }
        if (z) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (z) {
            add(sb, "phone_orientation", phone_orientation);
        }
        if (this.mCustom.size() != 0) {
            sb.append("custom : {\n");
            for (String str : this.mCustom.keySet()) {
                CustomVariable customVariable = this.mCustom.get(str);
                sb.append(str);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case 900:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                    case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_COLOR /* 902 */:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_STRING /* 903 */:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    private void serializeAnchor(StringBuilder sb, ConstraintAnchor.Type type) {
        ConstraintAnchor anchor = this.widget.getAnchor(type);
        if (anchor == null || anchor.mTarget == null) {
            return;
        }
        sb.append("Anchor");
        sb.append(type.name());
        sb.append(": ['");
        String str = anchor.mTarget.getOwner().stringId;
        if (str == null) {
            str = "#PARENT";
        }
        sb.append(str);
        sb.append("', '");
        sb.append(anchor.mTarget.getType().name());
        sb.append("', '");
        sb.append(anchor.mMargin);
        sb.append("'],\n");
    }

    private static void add(StringBuilder sb, String str, int i) {
        sb.append(str);
        sb.append(": ");
        sb.append(i);
        sb.append(",\n");
    }

    private static void add(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f);
        sb.append(",\n");
    }

    void printCustomAttributes() {
        String str;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = (".(" + stackTraceElement.getFileName() + StringUtils.PROCESS_POSTFIX_DELIMITER + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % 1000);
        if (this.widget != null) {
            str = str2 + RemoteSettings.FORWARD_SLASH_STRING + (this.widget.hashCode() % 1000) + " ";
        } else {
            str = str2 + "/NULL ";
        }
        HashMap<String, CustomVariable> hashMap = this.mCustom;
        if (hashMap != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                System.out.println(str + this.mCustom.get(it.next()).toString());
            }
        }
    }

    void logv(String str) {
        String str2;
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str3 = (".(" + stackTraceElement.getFileName() + StringUtils.PROCESS_POSTFIX_DELIMITER + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + " " + (hashCode() % 1000);
        if (this.widget != null) {
            str2 = str3 + RemoteSettings.FORWARD_SLASH_STRING + (this.widget.hashCode() % 1000);
        } else {
            str2 = str3 + "/NULL";
        }
        System.out.println(str2 + " " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMotionAttributes(TypedBundle typedBundle) {
        this.mMotionProperties = typedBundle;
    }

    public TypedBundle getMotionProperties() {
        return this.mMotionProperties;
    }
}
