package kotlinx.datetime.internal.format.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;
/* compiled from: ParserOperation.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0016B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlinx/datetime/internal/format/parser/StringSetParserOperation;", "Output", "Lkotlinx/datetime/internal/format/parser/ParserOperation;", "strings", "", "", "setter", "Lkotlinx/datetime/internal/format/parser/AssignableField;", "whatThisExpects", "<init>", "(Ljava/util/Collection;Lkotlinx/datetime/internal/format/parser/AssignableField;Ljava/lang/String;)V", "trie", "Lkotlinx/datetime/internal/format/parser/StringSetParserOperation$TrieNode;", "consume", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "storage", "input", "", "startIndex", "", "consume-FANa98k", "(Ljava/lang/Object;Ljava/lang/CharSequence;I)Ljava/lang/Object;", "TrieNode", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StringSetParserOperation<Output> implements ParserOperation<Output> {
    private final AssignableField<Output, String> setter;
    private final TrieNode trie;
    private final String whatThisExpects;

    /* JADX WARN: Multi-variable type inference failed */
    public StringSetParserOperation(Collection<String> strings, AssignableField<? super Output, String> setter, String whatThisExpects) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(whatThisExpects, "whatThisExpects");
        this.setter = setter;
        this.whatThisExpects = whatThisExpects;
        this.trie = new TrieNode(null, false, 3, null);
        for (String str : strings) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException(("Found an empty string in " + this.whatThisExpects).toString());
            }
            TrieNode trieNode = this.trie;
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                List<Pair<String, TrieNode>> children = trieNode.getChildren();
                final String valueOf = String.valueOf(charAt);
                int binarySearch = CollectionsKt.binarySearch(children, 0, children.size(), new Function1<Pair<? extends String, ? extends TrieNode>, Integer>() { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$special$$inlined$binarySearchBy$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Integer invoke(Pair<? extends String, ? extends StringSetParserOperation.TrieNode> pair) {
                        return Integer.valueOf(ComparisonsKt.compareValues(pair.getFirst(), valueOf));
                    }
                });
                if (binarySearch < 0) {
                    TrieNode trieNode2 = new TrieNode(null, false, 3, null);
                    trieNode.getChildren().add((-binarySearch) - 1, TuplesKt.to(String.valueOf(charAt), trieNode2));
                    trieNode = trieNode2;
                } else {
                    trieNode = trieNode.getChildren().get(binarySearch).getSecond();
                }
            }
            if (trieNode.isTerminal()) {
                throw new IllegalArgumentException(("The string '" + str + "' was passed several times").toString());
            }
            trieNode.setTerminal(true);
        }
        _init_$reduceTrie(this.trie);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ParserOperation.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00000\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/internal/format/parser/StringSetParserOperation$TrieNode;", "", "children", "", "Lkotlin/Pair;", "", "isTerminal", "", "<init>", "(Ljava/util/List;Z)V", "getChildren", "()Ljava/util/List;", "()Z", "setTerminal", "(Z)V", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class TrieNode {
        private final List<Pair<String, TrieNode>> children;
        private boolean isTerminal;

        public TrieNode() {
            this(null, false, 3, null);
        }

        public TrieNode(List<Pair<String, TrieNode>> children, boolean z) {
            Intrinsics.checkNotNullParameter(children, "children");
            this.children = children;
            this.isTerminal = z;
        }

        public /* synthetic */ TrieNode(ArrayList arrayList, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? false : z);
        }

        public final List<Pair<String, TrieNode>> getChildren() {
            return this.children;
        }

        public final boolean isTerminal() {
            return this.isTerminal;
        }

        public final void setTerminal(boolean z) {
            this.isTerminal = z;
        }
    }

    private static final void _init_$reduceTrie(TrieNode trieNode) {
        for (Pair<String, TrieNode> pair : trieNode.getChildren()) {
            _init_$reduceTrie(pair.component2());
        }
        ArrayList arrayList = new ArrayList();
        for (Pair<String, TrieNode> pair2 : trieNode.getChildren()) {
            String component1 = pair2.component1();
            TrieNode component2 = pair2.component2();
            if (!component2.isTerminal() && component2.getChildren().size() == 1) {
                Pair pair3 = (Pair) CollectionsKt.single((List<? extends Object>) component2.getChildren());
                arrayList.add(TuplesKt.to(component1 + ((String) pair3.component1()), (TrieNode) pair3.component2()));
            } else {
                arrayList.add(TuplesKt.to(component1, component2));
            }
        }
        trieNode.getChildren().clear();
        trieNode.getChildren().addAll(CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$_init_$reduceTrie$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Pair) t).getFirst(), (String) ((Pair) t2).getFirst());
            }
        }));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0052, code lost:
        r1.element += r4.length();
        r0 = r3;
        r13 = r5;
     */
    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    /* renamed from: consume-FANa98k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo10120consumeFANa98k(Output output, CharSequence input, final int i) {
        Intrinsics.checkNotNullParameter(input, "input");
        TrieNode trieNode = this.trie;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        Integer num = null;
        loop0: while (intRef.element <= input.length()) {
            if (trieNode.isTerminal()) {
                num = Integer.valueOf(intRef.element);
            }
            for (Pair<String, TrieNode> pair : trieNode.getChildren()) {
                String component1 = pair.component1();
                TrieNode component2 = pair.component2();
                CharSequence charSequence = input;
                if (StringsKt.startsWith$default(charSequence, (CharSequence) component1, intRef.element, false, 4, (Object) null)) {
                    break;
                }
                input = charSequence;
            }
        }
        final CharSequence charSequence2 = input;
        if (num != null) {
            return ParserOperationKt.access$setWithoutReassigning(this.setter, output, charSequence2.subSequence(i, num.intValue()).toString(), i, num.intValue());
        }
        return ParseResult.Companion.m10130ErrorRg3Co2E(i, new Function0() { // from class: kotlinx.datetime.internal.format.parser.StringSetParserOperation$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String consume_FANa98k$lambda$5;
                consume_FANa98k$lambda$5 = StringSetParserOperation.consume_FANa98k$lambda$5(StringSetParserOperation.this, charSequence2, i, intRef);
                return consume_FANa98k$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String consume_FANa98k$lambda$5(StringSetParserOperation stringSetParserOperation, CharSequence charSequence, int i, Ref.IntRef intRef) {
        return "Expected " + stringSetParserOperation.whatThisExpects + " but got " + charSequence.subSequence(i, intRef.element).toString();
    }
}
