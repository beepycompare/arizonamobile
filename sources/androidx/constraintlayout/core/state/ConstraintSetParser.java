package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.ChainReference;
import androidx.constraintlayout.core.state.helpers.FlowReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ConstraintSetParser {
    private static final boolean PARSER_DEBUG = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface GeneratedValue {
        float value();
    }

    /* loaded from: classes2.dex */
    public enum MotionLayoutDebugFlags {
        NONE,
        SHOW_ALL,
        UNKNOWN
    }

    /* loaded from: classes2.dex */
    public static class DesignElement {
        String mId;
        HashMap<String, String> mParams;
        String mType;

        public String getId() {
            return this.mId;
        }

        public String getType() {
            return this.mType;
        }

        public HashMap<String, String> getParams() {
            return this.mParams;
        }

        DesignElement(String str, String str2, HashMap<String, String> hashMap) {
            this.mId = str;
            this.mType = str2;
            this.mParams = hashMap;
        }
    }

    /* loaded from: classes2.dex */
    public static class LayoutVariables {
        HashMap<String, Integer> mMargins = new HashMap<>();
        HashMap<String, GeneratedValue> mGenerators = new HashMap<>();
        HashMap<String, ArrayList<String>> mArrayIds = new HashMap<>();

        void put(String str, int i) {
            this.mMargins.put(str, Integer.valueOf(i));
        }

        void put(String str, float f, float f2) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            this.mGenerators.put(str, new Generator(f, f2));
        }

        void put(String str, float f, float f2, float f3, String str2, String str3) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            FiniteGenerator finiteGenerator = new FiniteGenerator(f, f2, f3, str2, str3);
            this.mGenerators.put(str, finiteGenerator);
            this.mArrayIds.put(str, finiteGenerator.array());
        }

        public void putOverride(String str, float f) {
            this.mGenerators.put(str, new OverrideValue(f));
        }

        float get(Object obj) {
            if (obj instanceof CLString) {
                String content = ((CLString) obj).content();
                if (this.mGenerators.containsKey(content)) {
                    return this.mGenerators.get(content).value();
                }
                if (this.mMargins.containsKey(content)) {
                    return this.mMargins.get(content).floatValue();
                }
                return 0.0f;
            } else if (obj instanceof CLNumber) {
                return ((CLNumber) obj).getFloat();
            } else {
                return 0.0f;
            }
        }

        ArrayList<String> getList(String str) {
            if (this.mArrayIds.containsKey(str)) {
                return this.mArrayIds.get(str);
            }
            return null;
        }

        void put(String str, ArrayList<String> arrayList) {
            this.mArrayIds.put(str, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Generator implements GeneratedValue {
        float mCurrent;
        float mIncrementBy;
        float mStart;
        boolean mStop = false;

        Generator(float f, float f2) {
            this.mStart = f;
            this.mIncrementBy = f2;
            this.mCurrent = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            if (!this.mStop) {
                this.mCurrent += this.mIncrementBy;
            }
            return this.mCurrent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class FiniteGenerator implements GeneratedValue {
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        float mTo;
        boolean mStop = false;
        float mCurrent = 0.0f;

        FiniteGenerator(float f, float f2, float f3, String str, String str2) {
            this.mFrom = f;
            this.mTo = f2;
            this.mStep = f3;
            this.mPrefix = str == null ? "" : str;
            this.mPostfix = str2 == null ? "" : str2;
            this.mMax = f2;
            this.mInitial = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            float f = this.mCurrent;
            if (f >= this.mMax) {
                this.mStop = true;
            }
            if (!this.mStop) {
                this.mCurrent = f + this.mStep;
            }
            return this.mCurrent;
        }

        public ArrayList<String> array() {
            ArrayList<String> arrayList = new ArrayList<>();
            int i = (int) this.mInitial;
            int i2 = (int) this.mMax;
            int i3 = i;
            while (i <= i2) {
                arrayList.add(this.mPrefix + i3 + this.mPostfix);
                i3 += (int) this.mStep;
                i++;
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class OverrideValue implements GeneratedValue {
        float mValue;

        OverrideValue(float f) {
            this.mValue = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            return this.mValue;
        }
    }

    public static void parseJSON(String str, Transition transition, int i) {
        CLObject objectOrNull;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLElement cLElement = parse.get(next);
                if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull(SchedulerSupport.CUSTOM)) != null) {
                    Iterator<String> it2 = objectOrNull.names().iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        CLElement cLElement2 = objectOrNull.get(next2);
                        if (cLElement2 instanceof CLNumber) {
                            transition.addCustomFloat(i, next, next2, cLElement2.getFloat());
                        } else if (cLElement2 instanceof CLString) {
                            long parseColorString = parseColorString(cLElement2.content());
                            if (parseColorString != -1) {
                                transition.addCustomColor(i, next, next2, (int) parseColorString);
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x006a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x005d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void parseMotionSceneJSON(CoreMotionScene coreMotionScene, String str) {
        char c;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                CLElement cLElement = parse.get(next);
                if (cLElement instanceof CLObject) {
                    CLObject cLObject = (CLObject) cLElement;
                    int hashCode = next.hashCode();
                    if (hashCode == -2137403731) {
                        if (next.equals("Header")) {
                            c = 2;
                            if (c != 0) {
                            }
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                    } else if (hashCode != -241441378) {
                        if (hashCode == 1101852654 && next.equals("ConstraintSets")) {
                            c = 0;
                            if (c != 0) {
                                parseConstraintSets(coreMotionScene, cLObject);
                            } else if (c == 1) {
                                parseTransitions(coreMotionScene, cLObject);
                            } else if (c == 2) {
                                parseHeader(coreMotionScene, cLObject);
                            }
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                    } else {
                        if (next.equals(TypedValues.TransitionType.NAME)) {
                            c = 1;
                            if (c != 0) {
                            }
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                    }
                }
            }
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    static void parseConstraintSets(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLObject object = cLObject.getObject(next);
            String stringOrNull = object.getStringOrNull("Extends");
            if (stringOrNull != null && !stringOrNull.isEmpty()) {
                String constraintSet = coreMotionScene.getConstraintSet(stringOrNull);
                if (constraintSet != null) {
                    CLObject parse = CLParser.parse(constraintSet);
                    ArrayList<String> names2 = object.names();
                    if (names2 != null) {
                        Iterator<String> it2 = names2.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            CLElement cLElement = object.get(next2);
                            if (cLElement instanceof CLObject) {
                                override(parse, next2, (CLObject) cLElement);
                            }
                        }
                        coreMotionScene.setConstraintSetContent(next, parse.toJSON());
                    }
                }
            } else {
                coreMotionScene.setConstraintSetContent(next, object.toJSON());
            }
        }
    }

    static void override(CLObject cLObject, String str, CLObject cLObject2) throws CLParsingException {
        if (!cLObject.has(str)) {
            cLObject.put(str, cLObject2);
            return;
        }
        CLObject object = cLObject.getObject(str);
        Iterator<String> it = cLObject2.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!next.equals("clear")) {
                object.put(next, cLObject2.get(next));
            } else {
                CLArray array = cLObject2.getArray("clear");
                for (int i = 0; i < array.size(); i++) {
                    String stringOrNull = array.getStringOrNull(i);
                    if (stringOrNull != null) {
                        stringOrNull.hashCode();
                        char c = 65535;
                        switch (stringOrNull.hashCode()) {
                            case -1727069561:
                                if (stringOrNull.equals("transforms")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -1606703562:
                                if (stringOrNull.equals("constraints")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 414334925:
                                if (stringOrNull.equals("dimensions")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                object.remove("visibility");
                                object.remove("alpha");
                                object.remove("pivotX");
                                object.remove("pivotY");
                                object.remove("rotationX");
                                object.remove("rotationY");
                                object.remove("rotationZ");
                                object.remove("scaleX");
                                object.remove("scaleY");
                                object.remove("translationX");
                                object.remove("translationY");
                                break;
                            case 1:
                                object.remove(TtmlNode.START);
                                object.remove(TtmlNode.END);
                                object.remove("top");
                                object.remove("bottom");
                                object.remove("baseline");
                                object.remove(TtmlNode.CENTER);
                                object.remove("centerHorizontally");
                                object.remove("centerVertically");
                                break;
                            case 2:
                                object.remove("width");
                                object.remove("height");
                                break;
                            default:
                                object.remove(stringOrNull);
                                break;
                        }
                    }
                }
            }
        }
    }

    static void parseTransitions(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            coreMotionScene.setTransitionContent(next, cLObject.getObject(next).toJSON());
        }
    }

    static void parseHeader(CoreMotionScene coreMotionScene, CLObject cLObject) {
        String stringOrNull = cLObject.getStringOrNull("export");
        if (stringOrNull != null) {
            coreMotionScene.setDebugName(stringOrNull);
        }
    }

    public static void parseJSON(String str, State state, LayoutVariables layoutVariables) throws CLParsingException {
        try {
            populateState(CLParser.parse(str), state, layoutVariables);
        } catch (CLParsingException e) {
            System.err.println("Error parsing JSON " + e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bf, code lost:
        if (r3.equals("hChain") == false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void populateState(CLObject cLObject, State state, LayoutVariables layoutVariables) throws CLParsingException {
        boolean z;
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = cLObject.get(next);
            next.hashCode();
            char c = 2;
            switch (next.hashCode()) {
                case -1824489883:
                    if (next.equals("Helpers")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 1875016085:
                    if (next.equals("Generate")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1921490263:
                    if (next.equals("Variables")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    if (!(cLElement instanceof CLArray)) {
                        break;
                    } else {
                        parseHelpers(state, layoutVariables, (CLArray) cLElement);
                        break;
                    }
                case true:
                    if (!(cLElement instanceof CLObject)) {
                        break;
                    } else {
                        parseGenerate(state, layoutVariables, (CLObject) cLElement);
                        break;
                    }
                case true:
                    if (!(cLElement instanceof CLObject)) {
                        break;
                    } else {
                        parseVariables(state, layoutVariables, (CLObject) cLElement);
                        break;
                    }
                default:
                    if (cLElement instanceof CLObject) {
                        CLObject cLObject2 = (CLObject) cLElement;
                        String lookForType = lookForType(cLObject2);
                        if (lookForType != null) {
                            lookForType.hashCode();
                            switch (lookForType.hashCode()) {
                                case -1785507558:
                                    if (lookForType.equals("vGuideline")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1354837162:
                                    if (lookForType.equals("column")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1252464839:
                                    break;
                                case -851656725:
                                    if (lookForType.equals("vChain")) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -333143113:
                                    if (lookForType.equals("barrier")) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 113114:
                                    if (lookForType.equals("row")) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 3181382:
                                    if (lookForType.equals("grid")) {
                                        c = 6;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 98238902:
                                    if (lookForType.equals("hFlow")) {
                                        c = 7;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 111168196:
                                    if (lookForType.equals("vFlow")) {
                                        c = '\b';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 965681512:
                                    if (lookForType.equals("hGuideline")) {
                                        c = '\t';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    parseGuidelineParams(1, state, next, cLObject2);
                                    continue;
                                case 1:
                                case 5:
                                case 6:
                                    parseGridType(lookForType, state, next, layoutVariables, cLObject2);
                                    continue;
                                case 2:
                                case 3:
                                    parseChainType(lookForType, state, next, layoutVariables, cLObject2);
                                    continue;
                                case 4:
                                    parseBarrier(state, next, cLObject2);
                                    continue;
                                case 7:
                                case '\b':
                                    parseFlowType(lookForType, state, next, layoutVariables, cLObject2);
                                    continue;
                                case '\t':
                                    parseGuidelineParams(0, state, next, cLObject2);
                                    continue;
                            }
                        } else {
                            parseWidget(state, layoutVariables, next, cLObject2);
                            break;
                        }
                    } else if (!(cLElement instanceof CLNumber)) {
                        break;
                    } else {
                        layoutVariables.put(next, cLElement.getInt());
                        break;
                    }
            }
        }
    }

    private static void parseVariables(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = cLObject.get(next);
            if (cLElement instanceof CLNumber) {
                layoutVariables.put(next, cLElement.getInt());
            } else if (cLElement instanceof CLObject) {
                CLObject cLObject2 = (CLObject) cLElement;
                if (cLObject2.has("from") && cLObject2.has(TypedValues.TransitionType.S_TO)) {
                    layoutVariables.put(next, layoutVariables.get(cLObject2.get("from")), layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_TO)), 1.0f, cLObject2.getStringOrNull("prefix"), cLObject2.getStringOrNull("postfix"));
                } else if (cLObject2.has("from") && cLObject2.has("step")) {
                    layoutVariables.put(next, layoutVariables.get(cLObject2.get("from")), layoutVariables.get(cLObject2.get("step")));
                } else if (cLObject2.has("ids")) {
                    CLArray array = cLObject2.getArray("ids");
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int i = 0; i < array.size(); i++) {
                        arrayList.add(array.getString(i));
                    }
                    layoutVariables.put(next, arrayList);
                } else if (cLObject2.has("tag")) {
                    layoutVariables.put(next, state.getIdsForTag(cLObject2.getString("tag")));
                }
            }
        }
    }

    public static void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) throws CLParsingException {
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names != null && names.size() > 0) {
            String str2 = names.get(0);
            CLElement cLElement = parse.get(str2);
            str2.hashCode();
            if (str2.equals("Design") && (cLElement instanceof CLObject)) {
                CLObject cLObject = (CLObject) cLElement;
                ArrayList<String> names2 = cLObject.names();
                for (int i = 0; i < names2.size(); i++) {
                    String str3 = names2.get(i);
                    CLObject cLObject2 = (CLObject) cLObject.get(str3);
                    System.out.printf("element found " + str3 + "", new Object[0]);
                    String stringOrNull = cLObject2.getStringOrNull("type");
                    if (stringOrNull != null) {
                        HashMap hashMap = new HashMap();
                        int size = cLObject2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            CLKey cLKey = (CLKey) cLObject2.get(i);
                            String content = cLKey.content();
                            String content2 = cLKey.getValue().content();
                            if (content2 != null) {
                                hashMap.put(content, content2);
                            }
                        }
                        arrayList.add(new DesignElement(str2, stringOrNull, hashMap));
                    }
                }
            }
        }
    }

    static void parseHelpers(State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        for (int i = 0; i < cLArray.size(); i++) {
            CLElement cLElement = cLArray.get(i);
            if (cLElement instanceof CLArray) {
                CLArray cLArray2 = (CLArray) cLElement;
                if (cLArray2.size() > 1) {
                    String string = cLArray2.getString(0);
                    string.hashCode();
                    char c = 65535;
                    switch (string.hashCode()) {
                        case -1785507558:
                            if (string.equals("vGuideline")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1252464839:
                            if (string.equals("hChain")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -851656725:
                            if (string.equals("vChain")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 965681512:
                            if (string.equals("hGuideline")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            parseGuideline(1, state, cLArray2);
                            continue;
                        case 1:
                            parseChain(0, state, layoutVariables, cLArray2);
                            continue;
                        case 2:
                            parseChain(1, state, layoutVariables, cLArray2);
                            continue;
                        case 3:
                            parseGuideline(0, state, cLArray2);
                            continue;
                    }
                }
            }
        }
    }

    static void parseGenerate(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = cLObject.get(next);
            ArrayList<String> list = layoutVariables.getList(next);
            if (list != null && (cLElement instanceof CLObject)) {
                Iterator<String> it2 = list.iterator();
                while (it2.hasNext()) {
                    parseWidget(state, layoutVariables, it2.next(), (CLObject) cLElement);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void parseChain(int i, State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        String content;
        ChainReference horizontalChain = i == 0 ? state.horizontalChain() : state.verticalChain();
        CLElement cLElement = cLArray.get(1);
        if (cLElement instanceof CLArray) {
            CLArray cLArray2 = (CLArray) cLElement;
            if (cLArray2.size() < 1) {
                return;
            }
            for (int i2 = 0; i2 < cLArray2.size(); i2++) {
                horizontalChain.add(cLArray2.getString(i2));
            }
            if (cLArray.size() > 2) {
                CLElement cLElement2 = cLArray.get(2);
                if (cLElement2 instanceof CLObject) {
                    CLObject cLObject = (CLObject) cLElement2;
                    Iterator<String> it = cLObject.names().iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        next.hashCode();
                        if (next.equals("style")) {
                            CLElement cLElement3 = cLObject.get(next);
                            if (cLElement3 instanceof CLArray) {
                                CLArray cLArray3 = (CLArray) cLElement3;
                                if (cLArray3.size() > 1) {
                                    content = cLArray3.getString(0);
                                    horizontalChain.bias(cLArray3.getFloat(1));
                                    content.hashCode();
                                    if (!content.equals("packed")) {
                                        horizontalChain.style(State.Chain.PACKED);
                                    } else if (content.equals("spread_inside")) {
                                        horizontalChain.style(State.Chain.SPREAD_INSIDE);
                                    } else {
                                        horizontalChain.style(State.Chain.SPREAD);
                                    }
                                }
                            }
                            content = cLElement3.content();
                            content.hashCode();
                            if (!content.equals("packed")) {
                            }
                        } else {
                            parseConstraint(state, layoutVariables, cLObject, horizontalChain, next);
                        }
                    }
                }
            }
        }
    }

    private static float toPix(State state, float f) {
        return state.getDpToPixel().toPixels(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseChainType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        int i;
        CLArray cLArray;
        int i2;
        int i3;
        float f;
        String str3;
        float f2;
        float f3;
        float f4;
        float f5;
        String content;
        int i4 = 0;
        ChainReference horizontalChain = str.charAt(0) == 'h' ? state.horizontalChain() : state.verticalChain();
        horizontalChain.setKey(str2);
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            next.hashCode();
            int i5 = 6;
            int i6 = 3;
            int i7 = 2;
            int i8 = 1;
            int i9 = -1;
            switch (next.hashCode()) {
                case -1383228885:
                    if (next.equals("bottom")) {
                        i9 = i4;
                        break;
                    }
                    break;
                case -567445985:
                    if (next.equals("contains")) {
                        i9 = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (next.equals(TtmlNode.END)) {
                        i9 = 2;
                        break;
                    }
                    break;
                case 115029:
                    if (next.equals("top")) {
                        i9 = 3;
                        break;
                    }
                    break;
                case 3317767:
                    if (next.equals(TtmlNode.LEFT)) {
                        i9 = 4;
                        break;
                    }
                    break;
                case 108511772:
                    if (next.equals(TtmlNode.RIGHT)) {
                        i9 = 5;
                        break;
                    }
                    break;
                case 109757538:
                    if (next.equals(TtmlNode.START)) {
                        i9 = 6;
                        break;
                    }
                    break;
                case 109780401:
                    if (next.equals("style")) {
                        i9 = 7;
                        break;
                    }
                    break;
            }
            switch (i9) {
                case 0:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    parseConstraint(state, layoutVariables, cLObject, horizontalChain, next);
                    continue;
                    i4 = 0;
                case 1:
                    CLElement cLElement = cLObject.get(next);
                    if (cLElement instanceof CLArray) {
                        CLArray cLArray2 = (CLArray) cLElement;
                        if (cLArray2.size() >= 1) {
                            int i10 = i4;
                            while (i10 < cLArray2.size()) {
                                CLElement cLElement2 = cLArray2.get(i10);
                                if (cLElement2 instanceof CLArray) {
                                    CLArray cLArray3 = (CLArray) cLElement2;
                                    if (cLArray3.size() > 0) {
                                        String content2 = cLArray3.get(i4).content();
                                        int size = cLArray3.size();
                                        if (size == i7) {
                                            float f6 = cLArray3.getFloat(i8);
                                            CLArray cLArray4 = cLArray2;
                                            f = f6;
                                            cLArray = cLArray4;
                                            i = i10;
                                            i3 = i8;
                                            str3 = content2;
                                            f2 = Float.NaN;
                                        } else {
                                            if (size == i6) {
                                                CLArray cLArray5 = cLArray2;
                                                f = cLArray3.getFloat(i8);
                                                cLArray = cLArray5;
                                                i = i10;
                                                i3 = i8;
                                                f2 = toPix(state, cLArray3.getFloat(i7));
                                                str3 = content2;
                                                f3 = Float.NaN;
                                                i2 = i7;
                                                f5 = f2;
                                                f4 = Float.NaN;
                                            } else if (size == 4) {
                                                float f7 = cLArray3.getFloat(i8);
                                                float pix = toPix(state, cLArray3.getFloat(i7));
                                                i6 = 3;
                                                CLArray cLArray6 = cLArray2;
                                                f = f7;
                                                cLArray = cLArray6;
                                                i3 = i8;
                                                f2 = toPix(state, cLArray3.getFloat(3));
                                                f4 = Float.NaN;
                                                i2 = i7;
                                                f5 = pix;
                                                i = i10;
                                                str3 = content2;
                                                f3 = Float.NaN;
                                            } else if (size != i5) {
                                                i = i10;
                                                cLArray = cLArray2;
                                                i3 = i8;
                                                str3 = content2;
                                                f = Float.NaN;
                                                f2 = Float.NaN;
                                            } else {
                                                float f8 = cLArray3.getFloat(i8);
                                                float pix2 = toPix(state, cLArray3.getFloat(i7));
                                                float pix3 = toPix(state, cLArray3.getFloat(i6));
                                                float pix4 = toPix(state, cLArray3.getFloat(4));
                                                int i11 = i7;
                                                f5 = pix2;
                                                cLArray = cLArray2;
                                                f = f8;
                                                i2 = i11;
                                                i3 = i8;
                                                f2 = pix3;
                                                i = i10;
                                                str3 = content2;
                                                f3 = toPix(state, cLArray3.getFloat(5));
                                                f4 = pix4;
                                                i6 = 3;
                                            }
                                            horizontalChain.addChainElement(str3, f, f5, f2, f4, f3);
                                        }
                                        f4 = f2;
                                        f3 = f4;
                                        i2 = i7;
                                        f5 = f3;
                                        horizontalChain.addChainElement(str3, f, f5, f2, f4, f3);
                                    } else {
                                        i = i10;
                                        cLArray = cLArray2;
                                        i2 = i7;
                                        i3 = i8;
                                    }
                                } else {
                                    i = i10;
                                    cLArray = cLArray2;
                                    i2 = i7;
                                    i3 = i8;
                                    horizontalChain.add(cLElement2.content());
                                }
                                i10 = i + 1;
                                cLArray2 = cLArray;
                                i7 = i2;
                                i8 = i3;
                                i4 = 0;
                                i5 = 6;
                            }
                            break;
                        }
                    }
                    System.err.println(str2 + " contains should be an array \"" + cLElement.content() + "\"");
                    return;
                case 7:
                    CLElement cLElement3 = cLObject.get(next);
                    if (cLElement3 instanceof CLArray) {
                        CLArray cLArray7 = (CLArray) cLElement3;
                        if (cLArray7.size() > 1) {
                            content = cLArray7.getString(i4);
                            horizontalChain.bias(cLArray7.getFloat(1));
                            content.hashCode();
                            if (!content.equals("packed")) {
                                horizontalChain.style(State.Chain.PACKED);
                                break;
                            } else if (content.equals("spread_inside")) {
                                horizontalChain.style(State.Chain.SPREAD_INSIDE);
                                break;
                            } else {
                                horizontalChain.style(State.Chain.SPREAD);
                                break;
                            }
                        }
                    }
                    content = cLElement3.content();
                    content.hashCode();
                    if (!content.equals("packed")) {
                    }
            }
            i4 = 0;
        }
    }

    private static void parseGridType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        float f;
        float f2;
        float f3;
        float f4;
        GridReference grid = state.getGrid(str2, str);
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            next.hashCode();
            int i = 0;
            char c = 65535;
            switch (next.hashCode()) {
                case -1439500848:
                    if (next.equals("orientation")) {
                        c = 0;
                        break;
                    }
                    break;
                case -806339567:
                    if (next.equals("padding")) {
                        c = 1;
                        break;
                    }
                    break;
                case -567445985:
                    if (next.equals("contains")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3169614:
                    if (next.equals("hGap")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3506649:
                    if (next.equals("rows")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3586688:
                    if (next.equals("vGap")) {
                        c = 5;
                        break;
                    }
                    break;
                case 97513095:
                    if (next.equals(DownloaderServiceMarshaller.PARAMS_FLAGS)) {
                        c = 6;
                        break;
                    }
                    break;
                case 109497044:
                    if (next.equals("skips")) {
                        c = 7;
                        break;
                    }
                    break;
                case 109638249:
                    if (next.equals("spans")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 144441793:
                    if (next.equals("rowWeights")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 949721053:
                    if (next.equals("columns")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 2033353925:
                    if (next.equals("columnWeights")) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    grid.setOrientation(cLObject.get(next).getInt());
                    break;
                case 1:
                    CLElement cLElement = cLObject.get(next);
                    if (cLElement instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLElement;
                        if (cLArray.size() > 1) {
                            f = cLArray.getInt(0);
                            f4 = cLArray.getInt(1);
                            if (cLArray.size() > 2) {
                                f3 = cLArray.getInt(2);
                                try {
                                    f2 = ((CLArray) cLElement).getInt(3);
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    f2 = 0.0f;
                                }
                            } else {
                                f2 = f4;
                                f3 = f;
                            }
                            grid.setPaddingStart(Math.round(toPix(state, f)));
                            grid.setPaddingTop(Math.round(toPix(state, f4)));
                            grid.setPaddingEnd(Math.round(toPix(state, f3)));
                            grid.setPaddingBottom(Math.round(toPix(state, f2)));
                            break;
                        }
                    }
                    f = cLElement.getInt();
                    f2 = f;
                    f3 = f2;
                    f4 = f3;
                    grid.setPaddingStart(Math.round(toPix(state, f)));
                    grid.setPaddingTop(Math.round(toPix(state, f4)));
                    grid.setPaddingEnd(Math.round(toPix(state, f3)));
                    grid.setPaddingBottom(Math.round(toPix(state, f2)));
                case 2:
                    CLArray arrayOrNull = cLObject.getArrayOrNull(next);
                    if (arrayOrNull == null) {
                        break;
                    } else {
                        while (i < arrayOrNull.size()) {
                            grid.add(state.constraints(arrayOrNull.get(i).content()));
                            i++;
                        }
                        break;
                    }
                case 3:
                    grid.setHorizontalGaps(toPix(state, cLObject.get(next).getFloat()));
                    break;
                case 4:
                    int i2 = cLObject.get(next).getInt();
                    if (i2 <= 0) {
                        break;
                    } else {
                        grid.setRowsSet(i2);
                        break;
                    }
                case 5:
                    grid.setVerticalGaps(toPix(state, cLObject.get(next).getFloat()));
                    break;
                case 6:
                    String str3 = "";
                    try {
                        CLElement cLElement2 = cLObject.get(next);
                        if (cLElement2 instanceof CLNumber) {
                            i = cLElement2.getInt();
                        } else {
                            str3 = cLElement2.content();
                        }
                    } catch (Exception e) {
                        System.err.println("Error parsing grid flags " + e);
                    }
                    if (str3 != null && !str3.isEmpty()) {
                        grid.setFlags(str3);
                        break;
                    } else {
                        grid.setFlags(i);
                        break;
                    }
                case 7:
                    String content = cLObject.get(next).content();
                    if (content != null && content.contains(StringUtils.PROCESS_POSTFIX_DELIMITER)) {
                        grid.setSkips(content);
                        break;
                    }
                    break;
                case '\b':
                    String content2 = cLObject.get(next).content();
                    if (content2 != null && content2.contains(StringUtils.PROCESS_POSTFIX_DELIMITER)) {
                        grid.setSpans(content2);
                        break;
                    }
                    break;
                case '\t':
                    String content3 = cLObject.get(next).content();
                    if (content3 != null && content3.contains(StringUtils.COMMA)) {
                        grid.setRowWeights(content3);
                        break;
                    }
                    break;
                case '\n':
                    int i3 = cLObject.get(next).getInt();
                    if (i3 <= 0) {
                        break;
                    } else {
                        grid.setColumnsSet(i3);
                        break;
                    }
                case 11:
                    String content4 = cLObject.get(next).content();
                    if (content4 != null && content4.contains(StringUtils.COMMA)) {
                        grid.setColumnWeights(content4);
                        break;
                    }
                    break;
                default:
                    applyAttribute(state, layoutVariables, state.constraints(str2), cLObject, next);
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0249 A[Catch: NumberFormatException -> 0x0021, TryCatch #1 {NumberFormatException -> 0x0021, blocks: (B:109:0x023a, B:111:0x0249, B:112:0x0250, B:114:0x0258, B:175:0x03b4, B:177:0x03c3, B:178:0x03ca, B:180:0x03d2), top: B:211:0x023a }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03c3 A[Catch: NumberFormatException -> 0x0021, TryCatch #1 {NumberFormatException -> 0x0021, blocks: (B:109:0x023a, B:111:0x0249, B:112:0x0250, B:114:0x0258, B:175:0x03b4, B:177:0x03c3, B:178:0x03ca, B:180:0x03d2), top: B:211:0x023a }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0258 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x031a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0429 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0021 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseFlowType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        char c;
        String content;
        String str3;
        String str4;
        Float valueOf;
        String content2;
        String str5;
        String str6;
        float f;
        float f2;
        float f3;
        float f4;
        Float valueOf2;
        float f5;
        float f6;
        float f7;
        float f8;
        FlowReference flow = state.getFlow(str2, str.charAt(0) == 'v');
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            String next = it.next();
            next.hashCode();
            int i = 4;
            char c2 = 65535;
            switch (next.hashCode()) {
                case -1254185091:
                    if (next.equals("hAlign")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1237307863:
                    if (next.equals("hStyle")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1198076529:
                    if (next.equals("hFlowBias")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -853376977:
                    if (next.equals("vAlign")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -836499749:
                    if (next.equals("vStyle")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -806339567:
                    if (next.equals("padding")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -732635235:
                    if (next.equals("vFlowBias")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -567445985:
                    if (next.equals("contains")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -488900360:
                    if (next.equals("maxElement")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 3169614:
                    if (next.equals("hGap")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 3575610:
                    if (next.equals("type")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 3586688:
                    if (next.equals("vGap")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 3657802:
                    if (next.equals("wrap")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    String content3 = cLObject.get(next).content();
                    content3.hashCode();
                    if (!content3.equals(TtmlNode.END)) {
                        if (content3.equals(TtmlNode.START)) {
                            flow.setHorizontalAlign(0);
                            break;
                        } else {
                            flow.setHorizontalAlign(2);
                            break;
                        }
                    } else {
                        flow.setHorizontalAlign(1);
                        break;
                    }
                case 1:
                    CLElement cLElement = cLObject.get(next);
                    if (cLElement instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLElement;
                        if (cLArray.size() > 1) {
                            str3 = cLArray.getString(0);
                            content = cLArray.getString(1);
                            if (cLArray.size() > 2) {
                                str4 = cLArray.getString(2);
                            } else {
                                str4 = "";
                            }
                            if (!content.equals("")) {
                                flow.setHorizontalStyle(State.Chain.getValueByString(content));
                            }
                            if (!str3.equals("")) {
                                flow.setFirstHorizontalStyle(State.Chain.getValueByString(str3));
                            }
                            if (!str4.equals("")) {
                                break;
                            } else {
                                flow.setLastHorizontalStyle(State.Chain.getValueByString(str4));
                                break;
                            }
                        }
                    }
                    content = cLElement.content();
                    str3 = "";
                    str4 = str3;
                    if (!content.equals("")) {
                    }
                    if (!str3.equals("")) {
                    }
                    if (!str4.equals("")) {
                    }
                case 2:
                    CLElement cLElement2 = cLObject.get(next);
                    Float.valueOf(0.5f);
                    Float valueOf3 = Float.valueOf(0.5f);
                    Float valueOf4 = Float.valueOf(0.5f);
                    if (cLElement2 instanceof CLArray) {
                        CLArray cLArray2 = (CLArray) cLElement2;
                        if (cLArray2.size() > 1) {
                            valueOf3 = Float.valueOf(cLArray2.getFloat(0));
                            valueOf = Float.valueOf(cLArray2.getFloat(1));
                            if (cLArray2.size() > 2) {
                                valueOf4 = Float.valueOf(cLArray2.getFloat(2));
                            }
                            flow.horizontalBias(valueOf.floatValue());
                            if (valueOf3.floatValue() != 0.5f) {
                                flow.setFirstHorizontalBias(valueOf3.floatValue());
                            }
                            if (valueOf4.floatValue() != 0.5f) {
                                break;
                            } else {
                                flow.setLastHorizontalBias(valueOf4.floatValue());
                                break;
                            }
                        }
                    }
                    valueOf = Float.valueOf(cLElement2.getFloat());
                    flow.horizontalBias(valueOf.floatValue());
                    if (valueOf3.floatValue() != 0.5f) {
                    }
                    if (valueOf4.floatValue() != 0.5f) {
                    }
                case 3:
                    String content4 = cLObject.get(next).content();
                    content4.hashCode();
                    switch (content4.hashCode()) {
                        case -1720785339:
                            if (content4.equals("baseline")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case -1383228885:
                            if (content4.equals("bottom")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 115029:
                            if (content4.equals("top")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            flow.setVerticalAlign(3);
                            continue;
                        case 1:
                            flow.setVerticalAlign(1);
                            continue;
                        case 2:
                            flow.setVerticalAlign(0);
                            continue;
                        default:
                            flow.setVerticalAlign(2);
                            continue;
                    }
                case 4:
                    CLElement cLElement3 = cLObject.get(next);
                    if (cLElement3 instanceof CLArray) {
                        CLArray cLArray3 = (CLArray) cLElement3;
                        if (cLArray3.size() > 1) {
                            str5 = cLArray3.getString(0);
                            content2 = cLArray3.getString(1);
                            if (cLArray3.size() > 2) {
                                str6 = cLArray3.getString(2);
                            } else {
                                str6 = "";
                            }
                            if (!content2.equals("")) {
                                flow.setVerticalStyle(State.Chain.getValueByString(content2));
                            }
                            if (!str5.equals("")) {
                                flow.setFirstVerticalStyle(State.Chain.getValueByString(str5));
                            }
                            if (!str6.equals("")) {
                                break;
                            } else {
                                flow.setLastVerticalStyle(State.Chain.getValueByString(str6));
                                break;
                            }
                        }
                    }
                    content2 = cLElement3.content();
                    str5 = "";
                    str6 = str5;
                    if (!content2.equals("")) {
                    }
                    if (!str5.equals("")) {
                    }
                    if (!str6.equals("")) {
                    }
                case 5:
                    CLElement cLElement4 = cLObject.get(next);
                    if (cLElement4 instanceof CLArray) {
                        CLArray cLArray4 = (CLArray) cLElement4;
                        if (cLArray4.size() > 1) {
                            f = cLArray4.getInt(0);
                            f4 = cLArray4.getInt(1);
                            if (cLArray4.size() > 2) {
                                f3 = cLArray4.getInt(2);
                                try {
                                    f2 = ((CLArray) cLElement4).getInt(3);
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    f2 = 0.0f;
                                }
                            } else {
                                f3 = f;
                                f2 = f4;
                            }
                            flow.setPaddingLeft(Math.round(toPix(state, f)));
                            flow.setPaddingTop(Math.round(toPix(state, f4)));
                            flow.setPaddingRight(Math.round(toPix(state, f3)));
                            flow.setPaddingBottom(Math.round(toPix(state, f2)));
                            break;
                        }
                    }
                    f = cLElement4.getInt();
                    f2 = f;
                    f3 = f2;
                    f4 = f3;
                    flow.setPaddingLeft(Math.round(toPix(state, f)));
                    flow.setPaddingTop(Math.round(toPix(state, f4)));
                    flow.setPaddingRight(Math.round(toPix(state, f3)));
                    flow.setPaddingBottom(Math.round(toPix(state, f2)));
                case 6:
                    CLElement cLElement5 = cLObject.get(next);
                    Float.valueOf(0.5f);
                    Float valueOf5 = Float.valueOf(0.5f);
                    Float valueOf6 = Float.valueOf(0.5f);
                    try {
                        if (cLElement5 instanceof CLArray) {
                            CLArray cLArray5 = (CLArray) cLElement5;
                            if (cLArray5.size() > 1) {
                                valueOf5 = Float.valueOf(cLArray5.getFloat(0));
                                valueOf2 = Float.valueOf(cLArray5.getFloat(1));
                                if (cLArray5.size() > 2) {
                                    valueOf6 = Float.valueOf(cLArray5.getFloat(2));
                                }
                                flow.verticalBias(valueOf2.floatValue());
                                if (valueOf5.floatValue() != 0.5f) {
                                    flow.setFirstVerticalBias(valueOf5.floatValue());
                                }
                                if (valueOf6.floatValue() != 0.5f) {
                                    break;
                                } else {
                                    flow.setLastVerticalBias(valueOf6.floatValue());
                                    break;
                                }
                            }
                        }
                        flow.verticalBias(valueOf2.floatValue());
                        if (valueOf5.floatValue() != 0.5f) {
                        }
                        if (valueOf6.floatValue() != 0.5f) {
                        }
                    } catch (NumberFormatException unused2) {
                        break;
                    }
                    valueOf2 = Float.valueOf(cLElement5.getFloat());
                case 7:
                    CLElement cLElement6 = cLObject.get(next);
                    if (cLElement6 instanceof CLArray) {
                        CLArray cLArray6 = (CLArray) cLElement6;
                        if (cLArray6.size() >= 1) {
                            int i2 = 0;
                            while (i2 < cLArray6.size()) {
                                CLElement cLElement7 = cLArray6.get(i2);
                                if (cLElement7 instanceof CLArray) {
                                    CLArray cLArray7 = (CLArray) cLElement7;
                                    if (cLArray7.size() > 0) {
                                        String content5 = cLArray7.get(0).content();
                                        int size = cLArray7.size();
                                        if (size != 2) {
                                            if (size == 3) {
                                                f8 = cLArray7.getFloat(1);
                                                f6 = toPix(state, cLArray7.getFloat(2));
                                                f7 = f6;
                                            } else if (size != i) {
                                                f6 = Float.NaN;
                                                f5 = Float.NaN;
                                                f7 = Float.NaN;
                                            } else {
                                                f8 = cLArray7.getFloat(1);
                                                f7 = toPix(state, cLArray7.getFloat(2));
                                                f6 = toPix(state, cLArray7.getFloat(3));
                                            }
                                            f5 = f8;
                                        } else {
                                            f5 = cLArray7.getFloat(1);
                                            f6 = Float.NaN;
                                            f7 = Float.NaN;
                                        }
                                        flow.addFlowElement(content5, f5, f7, f6);
                                    }
                                } else {
                                    flow.add(cLElement7.content());
                                }
                                i2++;
                                i = 4;
                            }
                            break;
                        }
                    }
                    System.err.println(str2 + " contains should be an array \"" + cLElement6.content() + "\"");
                    return;
                case '\b':
                    flow.setMaxElementsWrap(cLObject.get(next).getInt());
                    break;
                case '\t':
                    flow.setHorizontalGap(cLObject.get(next).getInt());
                    break;
                case '\n':
                    if (cLObject.get(next).content().equals("hFlow")) {
                        flow.setOrientation(0);
                        break;
                    } else {
                        flow.setOrientation(1);
                        break;
                    }
                case 11:
                    flow.setVerticalGap(cLObject.get(next).getInt());
                    break;
                case '\f':
                    flow.setWrapMode(State.Wrap.getValueByString(cLObject.get(next).content()));
                    break;
                default:
                    applyAttribute(state, layoutVariables, state.constraints(str2), cLObject, next);
                    break;
            }
        }
    }

    static void parseGuideline(int i, State state, CLArray cLArray) throws CLParsingException {
        CLObject cLObject;
        String stringOrNull;
        CLElement cLElement = cLArray.get(1);
        if ((cLElement instanceof CLObject) && (stringOrNull = (cLObject = (CLObject) cLElement).getStringOrNull("id")) != null) {
            parseGuidelineParams(i, state, stringOrNull, cLObject);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static void parseGuidelineParams(int i, State state, String str, CLObject cLObject) throws CLParsingException {
        String next;
        char c;
        char c2;
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        ConstraintReference constraints = state.constraints(str);
        if (i == 0) {
            state.horizontalGuideline(str);
        } else {
            state.verticalGuideline(str);
        }
        boolean z = !state.isRtl() || i == 0;
        GuidelineReference guidelineReference = (GuidelineReference) constraints.getFacade();
        Iterator<String> it = names.iterator();
        float f = 0.0f;
        boolean z2 = false;
        while (true) {
            boolean z3 = true;
            while (it.hasNext()) {
                next = it.next();
                next.hashCode();
                switch (next.hashCode()) {
                    case -678927291:
                        if (next.equals("percent")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 100571:
                        if (next.equals(TtmlNode.END)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3317767:
                        if (next.equals(TtmlNode.LEFT)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 108511772:
                        if (next.equals(TtmlNode.RIGHT)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 109757538:
                        if (next.equals(TtmlNode.START)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        CLArray arrayOrNull = cLObject.getArrayOrNull(next);
                        if (arrayOrNull == null) {
                            f = cLObject.getFloat(next);
                            z2 = true;
                            z3 = true;
                        } else {
                            if (arrayOrNull.size() > 1) {
                                String string = arrayOrNull.getString(0);
                                float f2 = arrayOrNull.getFloat(1);
                                string.hashCode();
                                switch (string.hashCode()) {
                                    case 100571:
                                        if (string.equals(TtmlNode.END)) {
                                            c2 = 0;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 3317767:
                                        if (string.equals(TtmlNode.LEFT)) {
                                            c2 = 1;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 108511772:
                                        if (string.equals(TtmlNode.RIGHT)) {
                                            c2 = 2;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 109757538:
                                        if (string.equals(TtmlNode.START)) {
                                            c2 = 3;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    default:
                                        c2 = 65535;
                                        break;
                                }
                                switch (c2) {
                                    case 0:
                                        z3 = !z;
                                        f = f2;
                                        break;
                                    case 1:
                                        z3 = true;
                                        f = f2;
                                        z2 = true;
                                        break;
                                    case 2:
                                        z3 = false;
                                        f = f2;
                                        break;
                                    case 3:
                                        z3 = z;
                                        f = f2;
                                        break;
                                    default:
                                        f = f2;
                                        break;
                                }
                            }
                            z2 = true;
                        }
                    case 1:
                        f = toPix(state, cLObject.getFloat(next));
                        z3 = !z;
                    case 3:
                        f = toPix(state, cLObject.getFloat(next));
                        z3 = false;
                    case 4:
                        f = toPix(state, cLObject.getFloat(next));
                        z3 = z;
                }
            }
            if (z2) {
                if (z3) {
                    guidelineReference.percent(f);
                    return;
                } else {
                    guidelineReference.percent(1.0f - f);
                    return;
                }
            } else if (z3) {
                guidelineReference.start(Float.valueOf(f));
                return;
            } else {
                guidelineReference.end(Float.valueOf(f));
                return;
            }
            f = toPix(state, cLObject.getFloat(next));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00af, code lost:
        if (r2.equals("top") == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void parseBarrier(State state, String str, CLObject cLObject) throws CLParsingException {
        boolean z;
        boolean isRtl = state.isRtl();
        BarrierReference barrier = state.barrier(str, State.Direction.END);
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            next.hashCode();
            char c = 2;
            switch (next.hashCode()) {
                case -1081309778:
                    if (next.equals("margin")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -567445985:
                    if (next.equals("contains")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    float floatOrNaN = cLObject.getFloatOrNaN(next);
                    if (Float.isNaN(floatOrNaN)) {
                        break;
                    } else {
                        barrier.margin(Float.valueOf(toPix(state, floatOrNaN)));
                        break;
                    }
                case true:
                    String string = cLObject.getString(next);
                    string.hashCode();
                    switch (string.hashCode()) {
                        case -1383228885:
                            if (string.equals("bottom")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 100571:
                            if (string.equals(TtmlNode.END)) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 115029:
                            break;
                        case 3317767:
                            if (string.equals(TtmlNode.LEFT)) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 108511772:
                            if (string.equals(TtmlNode.RIGHT)) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 109757538:
                            if (string.equals(TtmlNode.START)) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            barrier.setBarrierDirection(State.Direction.BOTTOM);
                            continue;
                        case 1:
                            if (!isRtl) {
                                barrier.setBarrierDirection(State.Direction.RIGHT);
                                break;
                            } else {
                                barrier.setBarrierDirection(State.Direction.LEFT);
                                continue;
                            }
                        case 2:
                            barrier.setBarrierDirection(State.Direction.TOP);
                            continue;
                        case 3:
                            barrier.setBarrierDirection(State.Direction.LEFT);
                            continue;
                        case 4:
                            barrier.setBarrierDirection(State.Direction.RIGHT);
                            continue;
                        case 5:
                            if (!isRtl) {
                                barrier.setBarrierDirection(State.Direction.LEFT);
                                break;
                            } else {
                                barrier.setBarrierDirection(State.Direction.RIGHT);
                                continue;
                            }
                    }
                case true:
                    CLArray arrayOrNull = cLObject.getArrayOrNull(next);
                    if (arrayOrNull != null) {
                        for (int i = 0; i < arrayOrNull.size(); i++) {
                            barrier.add(state.constraints(arrayOrNull.get(i).content()));
                        }
                        break;
                    } else {
                        break;
                    }
            }
        }
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        parseWidget(state, layoutVariables, state.constraints(str), cLObject);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x016b, code lost:
        if (r8.equals("visible") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void applyAttribute(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject, String str) throws CLParsingException {
        char c;
        ConstraintReference constraints;
        str.hashCode();
        char c2 = 2;
        switch (str.hashCode()) {
            case -1448775240:
                if (str.equals("centerVertically")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1349088399:
                if (str.equals(SchedulerSupport.CUSTOM)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1068318794:
                if (str.equals("motion")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -247669061:
                if (str.equals("hRtlBias")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -61505906:
                if (str.equals("vWeight")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 98116417:
                if (str.equals("hBias")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 111045711:
                if (str.equals("vBias")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 398344448:
                if (str.equals("hWeight")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1404070310:
                if (str.equals("centerHorizontally")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                String string = cLObject.getString(str);
                boolean equals = string.equals("parent");
                Object obj = string;
                if (equals) {
                    obj = State.PARENT;
                }
                ConstraintReference constraints2 = state.constraints(obj);
                constraintReference.topToTop(constraints2);
                constraintReference.bottomToBottom(constraints2);
                return;
            case 1:
                String string2 = cLObject.getString(str);
                if (string2.equals("parent")) {
                    constraints = state.constraints(State.PARENT);
                } else {
                    constraints = state.constraints(string2);
                }
                constraintReference.startToStart(constraints);
                constraintReference.endToEnd(constraints);
                constraintReference.topToTop(constraints);
                constraintReference.bottomToBottom(constraints);
                return;
            case 2:
                parseCustomProperties(cLObject, constraintReference, str);
                return;
            case 3:
                constraintReference.rotationX(layoutVariables.get(cLObject.get(str)));
                return;
            case 4:
                constraintReference.rotationY(layoutVariables.get(cLObject.get(str)));
                return;
            case 5:
                constraintReference.rotationZ(layoutVariables.get(cLObject.get(str)));
                return;
            case 6:
                constraintReference.translationX(toPix(state, layoutVariables.get(cLObject.get(str))));
                return;
            case 7:
                constraintReference.translationY(toPix(state, layoutVariables.get(cLObject.get(str))));
                return;
            case '\b':
                constraintReference.translationZ(toPix(state, layoutVariables.get(cLObject.get(str))));
                return;
            case '\t':
                constraintReference.setHeight(parseDimension(cLObject, str, state, state.getDpToPixel()));
                return;
            case '\n':
                parseMotionProperties(cLObject.get(str), constraintReference);
                return;
            case 11:
                constraintReference.pivotX(layoutVariables.get(cLObject.get(str)));
                return;
            case '\f':
                constraintReference.pivotY(layoutVariables.get(cLObject.get(str)));
                return;
            case '\r':
                constraintReference.scaleX(layoutVariables.get(cLObject.get(str)));
                return;
            case 14:
                constraintReference.scaleY(layoutVariables.get(cLObject.get(str)));
                return;
            case 15:
                float f = layoutVariables.get(cLObject.get(str));
                if (state.isRtl()) {
                    f = 1.0f - f;
                }
                constraintReference.horizontalBias(f);
                return;
            case 16:
                constraintReference.setVerticalChainWeight(layoutVariables.get(cLObject.get(str)));
                return;
            case 17:
                constraintReference.alpha(layoutVariables.get(cLObject.get(str)));
                return;
            case 18:
                constraintReference.horizontalBias(layoutVariables.get(cLObject.get(str)));
                return;
            case 19:
                constraintReference.verticalBias(layoutVariables.get(cLObject.get(str)));
                return;
            case 20:
                constraintReference.setWidth(parseDimension(cLObject, str, state, state.getDpToPixel()));
                return;
            case 21:
                constraintReference.setHorizontalChainWeight(layoutVariables.get(cLObject.get(str)));
                return;
            case 22:
                String string3 = cLObject.getString(str);
                boolean equals2 = string3.equals("parent");
                Object obj2 = string3;
                if (equals2) {
                    obj2 = State.PARENT;
                }
                ConstraintReference constraints3 = state.constraints(obj2);
                constraintReference.startToStart(constraints3);
                constraintReference.endToEnd(constraints3);
                return;
            case 23:
                String string4 = cLObject.getString(str);
                string4.hashCode();
                switch (string4.hashCode()) {
                    case -1901805651:
                        if (string4.equals("invisible")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3178655:
                        if (string4.equals("gone")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 466743410:
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        constraintReference.visibility(4);
                        constraintReference.alpha(0.0f);
                        return;
                    case 1:
                        constraintReference.visibility(8);
                        return;
                    case 2:
                        constraintReference.visibility(0);
                        return;
                    default:
                        return;
                }
            default:
                parseConstraint(state, layoutVariables, cLObject, constraintReference, str);
                return;
        }
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject) throws CLParsingException {
        if (constraintReference.getWidth() == null) {
            constraintReference.setWidth(Dimension.createWrap());
        }
        if (constraintReference.getHeight() == null) {
            constraintReference.setHeight(Dimension.createWrap());
        }
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            applyAttribute(state, layoutVariables, constraintReference, cLObject, it.next());
        }
    }

    static void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList<String> names;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull == null || (names = objectOrNull.names()) == null) {
            return;
        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String next = it.next();
            CLElement cLElement = objectOrNull.get(next);
            if (cLElement instanceof CLNumber) {
                constraintReference.addCustomFloat(next, cLElement.getFloat());
            } else if (cLElement instanceof CLString) {
                long parseColorString = parseColorString(cLElement.content());
                if (parseColorString != -1) {
                    constraintReference.addCustomColor(next, (int) parseColorString);
                }
            }
        }
    }

    private static int indexOf(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void parseMotionProperties(CLElement cLElement, ConstraintReference constraintReference) throws CLParsingException {
        boolean z;
        if (cLElement instanceof CLObject) {
            CLObject cLObject = (CLObject) cLElement;
            TypedBundle typedBundle = new TypedBundle();
            ArrayList<String> names = cLObject.names();
            if (names == null) {
                return;
            }
            Iterator<String> it = names.iterator();
            while (it.hasNext()) {
                String next = it.next();
                next.hashCode();
                switch (next.hashCode()) {
                    case -1897525331:
                        if (next.equals("stagger")) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case -1310311125:
                        if (next.equals("easing")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -1285003983:
                        if (next.equals("quantize")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -791482387:
                        if (next.equals("pathArc")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case -236944793:
                        if (next.equals("relativeTo")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        typedBundle.add(600, cLObject.getFloat(next));
                        break;
                    case true:
                        typedBundle.add(TypedValues.MotionType.TYPE_EASING, cLObject.getString(next));
                        break;
                    case true:
                        CLElement cLElement2 = cLObject.get(next);
                        if (cLElement2 instanceof CLArray) {
                            CLArray cLArray = (CLArray) cLElement2;
                            int size = cLArray.size();
                            if (size <= 0) {
                                break;
                            } else {
                                typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLArray.getInt(0));
                                if (size <= 1) {
                                    break;
                                } else {
                                    typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE, cLArray.getString(1));
                                    if (size <= 2) {
                                        break;
                                    } else {
                                        typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, cLArray.getFloat(2));
                                        break;
                                    }
                                }
                            }
                        } else {
                            typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLObject.getInt(next));
                            break;
                        }
                    case true:
                        String string = cLObject.getString(next);
                        int indexOf = indexOf(string, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                        if (indexOf == -1) {
                            System.err.println(cLObject.getLine() + " pathArc = '" + string + "'");
                            break;
                        } else {
                            typedBundle.add(TypedValues.MotionType.TYPE_PATHMOTION_ARC, indexOf);
                            break;
                        }
                    case true:
                        typedBundle.add(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, cLObject.getString(next));
                        break;
                }
            }
            constraintReference.mMotionProperties = typedBundle;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void parseConstraint(State state, LayoutVariables layoutVariables, CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ConstraintReference constraints;
        char c;
        ConstraintReference constraints2;
        char c2;
        char c3;
        char c4;
        boolean z;
        char c5;
        boolean z2;
        char c6;
        boolean z3;
        char c7;
        boolean isRtl = state.isRtl();
        boolean z4 = !isRtl;
        CLArray arrayOrNull = cLObject.getArrayOrNull(str);
        char c8 = 65535;
        if (arrayOrNull != null && arrayOrNull.size() > 1) {
            String string = arrayOrNull.getString(0);
            String stringOrNull = arrayOrNull.getStringOrNull(1);
            float pix = arrayOrNull.size() > 2 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(2))) : 0.0f;
            float pix2 = arrayOrNull.size() > 3 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(3))) : 0.0f;
            if (string.equals("parent")) {
                constraints2 = state.constraints(State.PARENT);
            } else {
                constraints2 = state.constraints(string);
            }
            str.hashCode();
            float f = pix;
            switch (str.hashCode()) {
                case -1720785339:
                    if (str.equals("baseline")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1498085729:
                    if (str.equals("circular")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1383228885:
                    if (str.equals("bottom")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100571:
                    if (str.equals(TtmlNode.END)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3317767:
                    if (str.equals(TtmlNode.LEFT)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 108511772:
                    if (str.equals(TtmlNode.RIGHT)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109757538:
                    if (str.equals(TtmlNode.START)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    c3 = true;
                    c4 = 2;
                    stringOrNull.hashCode();
                    switch (stringOrNull.hashCode()) {
                        case -1720785339:
                            if (stringOrNull.equals("baseline")) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case -1383228885:
                            if (stringOrNull.equals("bottom")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 115029:
                            if (stringOrNull.equals("top")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            state.baselineNeededFor(constraintReference.getKey());
                            state.baselineNeededFor(constraints2.getKey());
                            constraintReference.baselineToBaseline(constraints2);
                            break;
                        case true:
                            state.baselineNeededFor(constraintReference.getKey());
                            constraintReference.baselineToBottom(constraints2);
                            break;
                        case true:
                            state.baselineNeededFor(constraintReference.getKey());
                            constraintReference.baselineToTop(constraints2);
                            break;
                    }
                    z2 = c3;
                    z3 = false;
                    if (z3) {
                        stringOrNull.hashCode();
                        switch (stringOrNull.hashCode()) {
                            case 100571:
                                if (stringOrNull.equals(TtmlNode.END)) {
                                    c8 = 0;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (stringOrNull.equals(TtmlNode.LEFT)) {
                                    c8 = c3;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (stringOrNull.equals(TtmlNode.RIGHT)) {
                                    c8 = c4;
                                    break;
                                }
                                break;
                            case 109757538:
                                if (stringOrNull.equals(TtmlNode.START)) {
                                    c8 = 3;
                                    break;
                                }
                                break;
                        }
                        switch (c8) {
                            case 0:
                                c7 = isRtl;
                                break;
                            case 1:
                            default:
                                c7 = c3;
                                break;
                            case 2:
                                c7 = false;
                                break;
                            case 3:
                                c7 = z4;
                                break;
                        }
                        if (z2) {
                            if (c7) {
                                constraintReference.leftToLeft(constraints2);
                            } else {
                                constraintReference.leftToRight(constraints2);
                            }
                        } else if (c7) {
                            constraintReference.rightToLeft(constraints2);
                        } else {
                            constraintReference.rightToRight(constraints2);
                        }
                    }
                    constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
                    return;
                case 1:
                    c3 = true;
                    constraintReference.circularConstraint(constraints2, layoutVariables.get(arrayOrNull.get(1)), arrayOrNull.size() > 2 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(2))) : 0.0f);
                    c4 = 2;
                    z2 = c3;
                    z3 = false;
                    if (z3) {
                    }
                    constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
                    return;
                case 2:
                    stringOrNull.hashCode();
                    switch (stringOrNull.hashCode()) {
                        case -1720785339:
                            if (stringOrNull.equals("baseline")) {
                                c5 = 0;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case -1383228885:
                            if (stringOrNull.equals("bottom")) {
                                c5 = 1;
                                break;
                            }
                            c5 = 65535;
                            break;
                        case 115029:
                            if (stringOrNull.equals("top")) {
                                c5 = 2;
                                break;
                            }
                            c5 = 65535;
                            break;
                        default:
                            c5 = 65535;
                            break;
                    }
                    switch (c5) {
                        case 0:
                            state.baselineNeededFor(constraints2.getKey());
                            constraintReference.bottomToBaseline(constraints2);
                            break;
                        case 1:
                            constraintReference.bottomToBottom(constraints2);
                            break;
                        case 2:
                            constraintReference.bottomToTop(constraints2);
                            break;
                    }
                    c3 = true;
                    c4 = 2;
                    z2 = c3;
                    z3 = false;
                    if (z3) {
                    }
                    constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
                    return;
                case 3:
                    z2 = isRtl;
                    c3 = true;
                    c4 = 2;
                    z3 = true;
                    if (z3) {
                    }
                    constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
                    return;
                case 4:
                    stringOrNull.hashCode();
                    switch (stringOrNull.hashCode()) {
                        case -1720785339:
                            if (stringOrNull.equals("baseline")) {
                                c6 = 0;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case -1383228885:
                            if (stringOrNull.equals("bottom")) {
                                c6 = 1;
                                break;
                            }
                            c6 = 65535;
                            break;
                        case 115029:
                            if (stringOrNull.equals("top")) {
                                c6 = 2;
                                break;
                            }
                            c6 = 65535;
                            break;
                        default:
                            c6 = 65535;
                            break;
                    }
                    switch (c6) {
                        case 0:
                            state.baselineNeededFor(constraints2.getKey());
                            constraintReference.topToBaseline(constraints2);
                            break;
                        case 1:
                            constraintReference.topToBottom(constraints2);
                            break;
                        case 2:
                            constraintReference.topToTop(constraints2);
                            break;
                    }
                    c3 = true;
                    c4 = 2;
                    z2 = c3;
                    z3 = false;
                    if (z3) {
                    }
                    constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
                    return;
                case 5:
                    z2 = true;
                    c3 = true;
                    c4 = 2;
                    z3 = true;
                    if (z3) {
                    }
                    constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
                    return;
                case 6:
                    z2 = false;
                    c3 = true;
                    c4 = 2;
                    z3 = true;
                    if (z3) {
                    }
                    constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
                    return;
                case 7:
                    z2 = z4;
                    c3 = true;
                    c4 = 2;
                    z3 = true;
                    if (z3) {
                    }
                    constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
                    return;
                default:
                    c3 = true;
                    c4 = 2;
                    z2 = c3;
                    z3 = false;
                    if (z3) {
                    }
                    constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
                    return;
            }
        }
        String stringOrNull2 = cLObject.getStringOrNull(str);
        if (stringOrNull2 != null) {
            if (stringOrNull2.equals("parent")) {
                constraints = state.constraints(State.PARENT);
            } else {
                constraints = state.constraints(stringOrNull2);
            }
            str.hashCode();
            switch (str.hashCode()) {
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1383228885:
                    if (str.equals("bottom")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 100571:
                    if (str.equals(TtmlNode.END)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (str.equals(TtmlNode.START)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    state.baselineNeededFor(constraintReference.getKey());
                    state.baselineNeededFor(constraints.getKey());
                    constraintReference.baselineToBaseline(constraints);
                    return;
                case 1:
                    constraintReference.bottomToBottom(constraints);
                    return;
                case 2:
                    if (!isRtl) {
                        constraintReference.rightToRight(constraints);
                        return;
                    } else {
                        constraintReference.leftToLeft(constraints);
                        return;
                    }
                case 3:
                    constraintReference.topToTop(constraints);
                    return;
                case 4:
                    if (!isRtl) {
                        constraintReference.leftToLeft(constraints);
                        return;
                    } else {
                        constraintReference.rightToRight(constraints);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    static Dimension parseDimensionMode(String str) {
        Dimension createFixed = Dimension.createFixed(0);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1460244870:
                if (str.equals("preferWrap")) {
                    c = 0;
                    break;
                }
                break;
            case -995424086:
                if (str.equals("parent")) {
                    c = 1;
                    break;
                }
                break;
            case -895684237:
                if (str.equals("spread")) {
                    c = 2;
                    break;
                }
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
            case 1:
                return Dimension.createParent();
            case 2:
                return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
            case 3:
                return Dimension.createWrap();
            default:
                if (str.endsWith("%")) {
                    return Dimension.createPercent(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).suggested(0);
                }
                return str.contains(StringUtils.PROCESS_POSTFIX_DELIMITER) ? Dimension.createRatio(str).suggested(Dimension.SPREAD_DIMENSION) : createFixed;
        }
    }

    static Dimension parseDimension(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) throws CLParsingException {
        CLElement cLElement = cLObject.get(str);
        Dimension createFixed = Dimension.createFixed(0);
        if (cLElement instanceof CLString) {
            return parseDimensionMode(cLElement.content());
        }
        if (cLElement instanceof CLNumber) {
            return Dimension.createFixed(state.convertDimension(Float.valueOf(corePixelDp.toPixels(cLObject.getFloat(str)))));
        }
        if (cLElement instanceof CLObject) {
            CLObject cLObject2 = (CLObject) cLElement;
            String stringOrNull = cLObject2.getStringOrNull("value");
            if (stringOrNull != null) {
                createFixed = parseDimensionMode(stringOrNull);
            }
            CLElement orNull = cLObject2.getOrNull("min");
            if (orNull != null) {
                if (orNull instanceof CLNumber) {
                    createFixed.min(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull).getFloat()))));
                } else if (orNull instanceof CLString) {
                    createFixed.min(Dimension.WRAP_DIMENSION);
                }
            }
            CLElement orNull2 = cLObject2.getOrNull("max");
            if (orNull2 != null) {
                if (orNull2 instanceof CLNumber) {
                    createFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
                    return createFixed;
                } else if (orNull2 instanceof CLString) {
                    createFixed.max(Dimension.WRAP_DIMENSION);
                }
            }
        }
        return createFixed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long parseColorString(String str) {
        if (str.startsWith("#")) {
            String substring = str.substring(1);
            if (substring.length() == 6) {
                substring = "FF" + substring;
            }
            return Long.parseLong(substring, 16);
        }
        return -1L;
    }

    static String lookForType(CLObject cLObject) throws CLParsingException {
        Iterator<String> it = cLObject.names().iterator();
        while (it.hasNext()) {
            if (it.next().equals("type")) {
                return cLObject.getString("type");
            }
        }
        return null;
    }
}
