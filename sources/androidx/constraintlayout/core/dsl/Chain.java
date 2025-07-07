package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.dsl.Constraint;
import androidx.constraintlayout.core.dsl.Helper;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class Chain extends Helper {
    protected static final Map<Style, String> styleMap;
    private Style mStyle;
    protected ArrayList<Ref> references;

    /* loaded from: classes2.dex */
    public enum Style {
        PACKED,
        SPREAD,
        SPREAD_INSIDE
    }

    static {
        HashMap hashMap = new HashMap();
        styleMap = hashMap;
        hashMap.put(Style.SPREAD, "'spread'");
        hashMap.put(Style.SPREAD_INSIDE, "'spread_inside'");
        hashMap.put(Style.PACKED, "'packed'");
    }

    public Chain(String str) {
        super(str, new Helper.HelperType(""));
        this.mStyle = null;
        this.references = new ArrayList<>();
    }

    public Style getStyle() {
        return this.mStyle;
    }

    public void setStyle(Style style) {
        this.mStyle = style;
        this.configMap.put("style", styleMap.get(style));
    }

    public String referencesToString() {
        if (this.references.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("[");
        Iterator<Ref> it = this.references.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public Chain addReference(Ref ref) {
        this.references.add(ref);
        this.configMap.put("contains", referencesToString());
        return this;
    }

    public Chain addReference(String str) {
        return addReference(Ref.parseStringToRef(str));
    }

    /* loaded from: classes2.dex */
    public class Anchor {
        Constraint.Anchor mConnection = null;
        int mGoneMargin = Integer.MIN_VALUE;
        int mMargin;
        final Constraint.Side mSide;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Anchor(Constraint.Side side) {
            this.mSide = side;
        }

        public String getId() {
            return Chain.this.name;
        }

        public void build(StringBuilder sb) {
            if (this.mConnection != null) {
                sb.append(this.mSide.toString().toLowerCase()).append(StringUtils.PROCESS_POSTFIX_DELIMITER).append(this).append(",\n");
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            if (this.mConnection != null) {
                sb.append("'").append(this.mConnection.getId()).append("','").append(this.mConnection.mSide.toString().toLowerCase()).append("'");
            }
            if (this.mMargin != 0) {
                sb.append(StringUtils.COMMA).append(this.mMargin);
            }
            if (this.mGoneMargin != Integer.MIN_VALUE) {
                if (this.mMargin == 0) {
                    sb.append(",0,").append(this.mGoneMargin);
                } else {
                    sb.append(StringUtils.COMMA).append(this.mGoneMargin);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
