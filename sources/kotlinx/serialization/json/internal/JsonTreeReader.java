package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
/* compiled from: JsonTreeReader.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\u000fH\u0082@¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015H\u0082\bJ\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0006\u0010\u001a\u001a\u00020\u000eJ\b\u0010\u001b\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "isLenient", "", "trailingCommaAllowed", "stackDepth", "", "readObject", "Lkotlinx/serialization/json/JsonElement;", "Lkotlin/DeepRecursiveScope;", "", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readObjectImpl", "Lkotlinx/serialization/json/JsonObject;", "reader", "Lkotlin/Function0;", "readArray", "readValue", "Lkotlinx/serialization/json/JsonPrimitive;", "isString", "read", "readDeepRecursive", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JsonTreeReader {
    private final boolean isLenient;
    private final AbstractJsonLexer lexer;
    private int stackDepth;
    private final boolean trailingCommaAllowed;

    public JsonTreeReader(JsonConfiguration configuration, AbstractJsonLexer lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.lexer = lexer;
        this.isLenient = configuration.isLenient();
        this.trailingCommaAllowed = configuration.getAllowTrailingComma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0097 -> B:27:0x00a1). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readObject(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Continuation<? super JsonElement> continuation) {
        JsonTreeReader$readObject$2 jsonTreeReader$readObject$2;
        int i;
        JsonTreeReader jsonTreeReader;
        LinkedHashMap linkedHashMap;
        JsonTreeReader$readObject$2 jsonTreeReader$readObject$22;
        byte b;
        DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope2;
        if (continuation instanceof JsonTreeReader$readObject$2) {
            jsonTreeReader$readObject$2 = (JsonTreeReader$readObject$2) continuation;
            if ((jsonTreeReader$readObject$2.label & Integer.MIN_VALUE) != 0) {
                jsonTreeReader$readObject$2.label -= Integer.MIN_VALUE;
                Object obj = jsonTreeReader$readObject$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = jsonTreeReader$readObject$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byte consumeNextToken = this.lexer.consumeNextToken((byte) 6);
                    if (this.lexer.peekNextToken() == 4) {
                        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    jsonTreeReader = this;
                    linkedHashMap = new LinkedHashMap();
                    jsonTreeReader$readObject$22 = jsonTreeReader$readObject$2;
                    b = consumeNextToken;
                    deepRecursiveScope2 = deepRecursiveScope;
                    if (jsonTreeReader.lexer.canConsumeValue()) {
                    }
                    if (b == 6) {
                    }
                    return new JsonObject(linkedHashMap);
                } else if (i == 1) {
                    String str = (String) jsonTreeReader$readObject$2.L$3;
                    linkedHashMap = (LinkedHashMap) jsonTreeReader$readObject$2.L$2;
                    jsonTreeReader = (JsonTreeReader) jsonTreeReader$readObject$2.L$1;
                    DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope3 = (DeepRecursiveScope) jsonTreeReader$readObject$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    linkedHashMap.put(str, (JsonElement) obj);
                    byte consumeNextToken2 = jsonTreeReader.lexer.consumeNextToken();
                    if (consumeNextToken2 == 4) {
                        if (consumeNextToken2 != 7) {
                            AbstractJsonLexer.fail$default(jsonTreeReader.lexer, "Expected end of the object or comma", 0, null, 6, null);
                            throw new KotlinNothingValueException();
                        }
                        b = consumeNextToken2;
                        if (b == 6) {
                            jsonTreeReader.lexer.consumeNextToken((byte) 7);
                        } else if (b == 4) {
                            if (!jsonTreeReader.trailingCommaAllowed) {
                                JsonExceptionsKt.invalidTrailingComma$default(jsonTreeReader.lexer, null, 1, null);
                                throw new KotlinNothingValueException();
                            }
                            jsonTreeReader.lexer.consumeNextToken((byte) 7);
                        }
                        return new JsonObject(linkedHashMap);
                    }
                    jsonTreeReader$readObject$22 = jsonTreeReader$readObject$2;
                    b = consumeNextToken2;
                    deepRecursiveScope2 = deepRecursiveScope3;
                    if (jsonTreeReader.lexer.canConsumeValue()) {
                        String consumeStringLenient = jsonTreeReader.isLenient ? jsonTreeReader.lexer.consumeStringLenient() : jsonTreeReader.lexer.consumeString();
                        jsonTreeReader.lexer.consumeNextToken((byte) 5);
                        Unit unit = Unit.INSTANCE;
                        jsonTreeReader$readObject$22.L$0 = deepRecursiveScope2;
                        jsonTreeReader$readObject$22.L$1 = jsonTreeReader;
                        jsonTreeReader$readObject$22.L$2 = linkedHashMap;
                        jsonTreeReader$readObject$22.L$3 = consumeStringLenient;
                        jsonTreeReader$readObject$22.label = 1;
                        Object callRecursive = deepRecursiveScope2.callRecursive(unit, jsonTreeReader$readObject$22);
                        if (callRecursive == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        deepRecursiveScope3 = deepRecursiveScope2;
                        obj = callRecursive;
                        JsonTreeReader$readObject$2 jsonTreeReader$readObject$23 = jsonTreeReader$readObject$22;
                        str = consumeStringLenient;
                        jsonTreeReader$readObject$2 = jsonTreeReader$readObject$23;
                        linkedHashMap.put(str, (JsonElement) obj);
                        byte consumeNextToken22 = jsonTreeReader.lexer.consumeNextToken();
                        if (consumeNextToken22 == 4) {
                        }
                    }
                    if (b == 6) {
                    }
                    return new JsonObject(linkedHashMap);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        jsonTreeReader$readObject$2 = new JsonTreeReader$readObject$2(this, continuation);
        Object obj2 = jsonTreeReader$readObject$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = jsonTreeReader$readObject$2.label;
        if (i != 0) {
        }
    }

    private final JsonObject readObjectImpl(Function0<? extends JsonElement> function0) {
        byte consumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.lexer.canConsumeValue()) {
                break;
            }
            String consumeStringLenient = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            linkedHashMap.put(consumeStringLenient, function0.invoke());
            consumeNextToken = this.lexer.consumeNextToken();
            if (consumeNextToken != 4) {
                if (consumeNextToken != 7) {
                    AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (consumeNextToken == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (consumeNextToken == 4) {
            if (!this.trailingCommaAllowed) {
                JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                throw new KotlinNothingValueException();
            }
            this.lexer.consumeNextToken((byte) 7);
        }
        return new JsonObject(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement readArray() {
        byte consumeNextToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.lexer.canConsumeValue()) {
            arrayList.add(read());
            consumeNextToken = this.lexer.consumeNextToken();
            if (consumeNextToken != 4) {
                AbstractJsonLexer abstractJsonLexer = this.lexer;
                boolean z = consumeNextToken == 9;
                int i = abstractJsonLexer.currentPosition;
                if (!z) {
                    AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected end of the array or comma", i, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (consumeNextToken == 8) {
            this.lexer.consumeNextToken((byte) 9);
        } else if (consumeNextToken == 4) {
            if (!this.trailingCommaAllowed) {
                JsonExceptionsKt.invalidTrailingComma(this.lexer, "array");
                throw new KotlinNothingValueException();
            }
            this.lexer.consumeNextToken((byte) 9);
        }
        return new JsonArray(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive readValue(boolean z) {
        String consumeStringLenient;
        if (this.isLenient || !z) {
            consumeStringLenient = this.lexer.consumeStringLenient();
        } else {
            consumeStringLenient = this.lexer.consumeString();
        }
        String str = consumeStringLenient;
        return (z || !Intrinsics.areEqual(str, AbstractJsonLexerKt.NULL)) ? new JsonLiteral(str, z, null, 4, null) : JsonNull.INSTANCE;
    }

    public final JsonElement read() {
        JsonElement readObject;
        byte peekNextToken = this.lexer.peekNextToken();
        if (peekNextToken == 1) {
            return readValue(true);
        }
        if (peekNextToken == 0) {
            return readValue(false);
        }
        if (peekNextToken != 6) {
            if (peekNextToken == 8) {
                return readArray();
            }
            AbstractJsonLexer.fail$default(this.lexer, "Cannot read Json element because of unexpected " + AbstractJsonLexerKt.tokenDescription(peekNextToken), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i = this.stackDepth + 1;
        this.stackDepth = i;
        if (i == 200) {
            readObject = readDeepRecursive();
        } else {
            readObject = readObject();
        }
        this.stackDepth--;
        return readObject;
    }

    private final JsonElement readDeepRecursive() {
        return (JsonElement) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new JsonTreeReader$readDeepRecursive$1(this, null)), Unit.INSTANCE);
    }

    private final JsonElement readObject() {
        byte consumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.lexer.canConsumeValue()) {
                break;
            }
            String consumeStringLenient = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
            this.lexer.consumeNextToken((byte) 5);
            linkedHashMap.put(consumeStringLenient, read());
            consumeNextToken = this.lexer.consumeNextToken();
            if (consumeNextToken != 4) {
                if (consumeNextToken != 7) {
                    AbstractJsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (consumeNextToken == 6) {
            this.lexer.consumeNextToken((byte) 7);
        } else if (consumeNextToken == 4) {
            if (!this.trailingCommaAllowed) {
                JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                throw new KotlinNothingValueException();
            }
            this.lexer.consumeNextToken((byte) 7);
        }
        return new JsonObject(linkedHashMap);
    }
}
