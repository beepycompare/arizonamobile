package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes2.dex */
public class CLParser {
    static boolean sDebug = false;
    private String mContent;
    private boolean mHasComment = false;
    private int mLineNumber;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    public CLObject parse() throws CLParsingException {
        int i;
        char c;
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i2 = 1;
        this.mLineNumber = 1;
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            char c2 = charArray[i3];
            if (c2 == '{') {
                break;
            }
            if (c2 == '\n') {
                this.mLineNumber++;
            }
            i3++;
        }
        if (i3 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject allocate = CLObject.allocate(charArray);
        allocate.setLine(this.mLineNumber);
        allocate.setStart(i3);
        int i4 = i3 + 1;
        CLObject cLObject = allocate;
        while (i4 < length) {
            char c3 = charArray[i4];
            if (c3 == '\n') {
                this.mLineNumber += i2;
            }
            if (this.mHasComment) {
                if (c3 == '\n') {
                    this.mHasComment = z;
                } else {
                    i = i2;
                    i4++;
                    i2 = i;
                    z = false;
                }
            }
            if (cLObject == null) {
                break;
            }
            if (cLObject.isDone()) {
                cLObject = getNextJsonElement(i4, c3, cLObject, charArray);
            } else if (cLObject instanceof CLObject) {
                if (c3 == '}') {
                    cLObject.setEnd(i4 - 1);
                } else {
                    cLObject = getNextJsonElement(i4, c3, cLObject, charArray);
                }
            } else if (!(cLObject instanceof CLArray)) {
                boolean z2 = cLObject instanceof CLString;
                if (z2) {
                    if (charArray[(int) cLObject.mStart] == c3) {
                        cLObject.setStart(cLObject.mStart + 1);
                        cLObject.setEnd(i4 - 1);
                    }
                } else {
                    if (cLObject instanceof CLToken) {
                        CLToken cLToken = (CLToken) cLObject;
                        i = i2;
                        if (!cLToken.validate(c3, i4)) {
                            throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                        }
                    } else {
                        i = i2;
                    }
                    if (((cLObject instanceof CLKey) || z2) && (((c = charArray[(int) cLObject.mStart]) == '\'' || c == '\"') && c == c3)) {
                        cLObject.setStart(cLObject.mStart + 1);
                        cLObject.setEnd(i4 - 1);
                    }
                    if (!cLObject.isDone() && (c3 == '}' || c3 == ']' || c3 == ',' || c3 == ' ' || c3 == '\t' || c3 == '\r' || c3 == '\n' || c3 == ':')) {
                        long j = i4 - 1;
                        cLObject.setEnd(j);
                        if (c3 == '}' || c3 == ']') {
                            cLObject = cLObject.getContainer();
                            cLObject.setEnd(j);
                            if (cLObject instanceof CLKey) {
                                cLObject = cLObject.getContainer();
                                cLObject.setEnd(j);
                            }
                        }
                    }
                    if (cLObject.isDone() && (!(cLObject instanceof CLKey) || ((CLKey) cLObject).mElements.size() > 0)) {
                        cLObject = cLObject.getContainer();
                    }
                    i4++;
                    i2 = i;
                    z = false;
                }
            } else if (c3 == ']') {
                cLObject.setEnd(i4 - 1);
            } else {
                cLObject = getNextJsonElement(i4, c3, cLObject, charArray);
            }
            i = i2;
            if (cLObject.isDone()) {
                cLObject = cLObject.getContainer();
            }
            i4++;
            i2 = i;
            z = false;
        }
        while (cLObject != null && !cLObject.isDone()) {
            if (cLObject instanceof CLString) {
                cLObject.setStart(((int) cLObject.mStart) + 1);
            }
            cLObject.setEnd(length - 1);
            cLObject = cLObject.getContainer();
        }
        if (sDebug) {
            System.out.println("Root: " + allocate.toJSON());
        }
        return allocate;
    }

    private CLElement getNextJsonElement(int i, char c, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
            if (c == '\"' || c == '\'') {
                if (cLElement instanceof CLObject) {
                    return createElement(cLElement, i, TYPE.KEY, true, cArr);
                }
                return createElement(cLElement, i, TYPE.STRING, true, cArr);
            } else if (c == '[') {
                return createElement(cLElement, i, TYPE.ARRAY, true, cArr);
            } else {
                if (c != ']') {
                    if (c == '{') {
                        return createElement(cLElement, i, TYPE.OBJECT, true, cArr);
                    }
                    if (c != '}') {
                        switch (c) {
                            case '+':
                            case '-':
                            case '.':
                            case '0':
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                            case '2':
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                            case '8':
                            case '9':
                                return createElement(cLElement, i, TYPE.NUMBER, true, cArr);
                            case ',':
                            case ':':
                                break;
                            case '/':
                                int i2 = i + 1;
                                if (i2 >= cArr.length || cArr[i2] != '/') {
                                    return cLElement;
                                }
                                this.mHasComment = true;
                                return cLElement;
                            default:
                                if ((cLElement instanceof CLContainer) && !(cLElement instanceof CLObject)) {
                                    CLElement createElement = createElement(cLElement, i, TYPE.TOKEN, true, cArr);
                                    CLToken cLToken = (CLToken) createElement;
                                    if (cLToken.validate(c, i)) {
                                        return createElement;
                                    }
                                    throw new CLParsingException("incorrect token <" + c + "> at line " + this.mLineNumber, cLToken);
                                }
                                return createElement(cLElement, i, TYPE.KEY, true, cArr);
                        }
                    }
                }
                cLElement.setEnd(i - 1);
                CLElement container = cLElement.getContainer();
                container.setEnd(i);
                return container;
            }
        }
        return cLElement;
    }

    private CLElement createElement(CLElement cLElement, int i, TYPE type, boolean z, char[] cArr) {
        CLElement allocate;
        if (sDebug) {
            System.out.println("CREATE " + type + " at " + cArr[i]);
        }
        switch (type.ordinal()) {
            case 1:
                allocate = CLObject.allocate(cArr);
                i++;
                break;
            case 2:
                allocate = CLArray.allocate(cArr);
                i++;
                break;
            case 3:
                allocate = CLNumber.allocate(cArr);
                break;
            case 4:
                allocate = CLString.allocate(cArr);
                break;
            case 5:
                allocate = CLKey.allocate(cArr);
                break;
            case 6:
                allocate = CLToken.allocate(cArr);
                break;
            default:
                allocate = null;
                break;
        }
        if (allocate == null) {
            return null;
        }
        allocate.setLine(this.mLineNumber);
        if (z) {
            allocate.setStart(i);
        }
        if (cLElement instanceof CLContainer) {
            allocate.setContainer((CLContainer) cLElement);
        }
        return allocate;
    }
}
