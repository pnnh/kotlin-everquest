#ifndef KONAN_LIBNATIVE_H
#define KONAN_LIBNATIVE_H
#ifdef __cplusplus
extern "C" {
#endif
#ifdef __cplusplus
typedef bool            libnative_KBoolean;
#else
typedef _Bool           libnative_KBoolean;
#endif
typedef unsigned short     libnative_KChar;
typedef signed char        libnative_KByte;
typedef short              libnative_KShort;
typedef int                libnative_KInt;
typedef long long          libnative_KLong;
typedef unsigned char      libnative_KUByte;
typedef unsigned short     libnative_KUShort;
typedef unsigned int       libnative_KUInt;
typedef unsigned long long libnative_KULong;
typedef float              libnative_KFloat;
typedef double             libnative_KDouble;
typedef float __attribute__ ((__vector_size__ (16))) libnative_KVector128;
typedef void*              libnative_KNativePtr;
struct libnative_KType;
typedef struct libnative_KType libnative_KType;

typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_kotlin_Byte;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_kotlin_Short;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_kotlin_Int;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_kotlin_Long;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_kotlin_Float;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_kotlin_Double;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_kotlin_Char;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_kotlin_Boolean;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_kotlin_Unit;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_xyz_sfx_base64_Base64Encoder;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_kotlin_ByteArray;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_xyz_sfx_base64_Base64Factory;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_xyz_sfx_base64_NativeBase64Encoder;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_xyz_sfx_utils_Clazz;
typedef struct {
  libnative_KNativePtr pinned;
} libnative_kref_xyz_sfx_utils_Object;


typedef struct {
  /* Service functions. */
  void (*DisposeStablePointer)(libnative_KNativePtr ptr);
  void (*DisposeString)(const char* string);
  libnative_KBoolean (*IsInstance)(libnative_KNativePtr ref, const libnative_KType* type);
  libnative_kref_kotlin_Byte (*createNullableByte)(libnative_KByte);
  libnative_kref_kotlin_Short (*createNullableShort)(libnative_KShort);
  libnative_kref_kotlin_Int (*createNullableInt)(libnative_KInt);
  libnative_kref_kotlin_Long (*createNullableLong)(libnative_KLong);
  libnative_kref_kotlin_Float (*createNullableFloat)(libnative_KFloat);
  libnative_kref_kotlin_Double (*createNullableDouble)(libnative_KDouble);
  libnative_kref_kotlin_Char (*createNullableChar)(libnative_KChar);
  libnative_kref_kotlin_Boolean (*createNullableBoolean)(libnative_KBoolean);
  libnative_kref_kotlin_Unit (*createNullableUnit)(void);

  /* User functions. */
  struct {
    struct {
      struct {
        struct {
          void (*SayHello)(const char* name);
          void (*main)();
          struct {
            struct {
              libnative_KType* (*_type)(void);
              libnative_kref_kotlin_ByteArray (*encode)(libnative_kref_xyz_sfx_base64_Base64Encoder thiz, libnative_kref_kotlin_ByteArray src);
              const char* (*encodeToString)(libnative_kref_xyz_sfx_base64_Base64Encoder thiz, libnative_kref_kotlin_ByteArray src);
            } Base64Encoder;
            struct {
              libnative_KType* (*_type)(void);
              libnative_kref_xyz_sfx_base64_Base64Factory (*_instance)();
              libnative_kref_xyz_sfx_base64_Base64Encoder (*createEncoder)(libnative_kref_xyz_sfx_base64_Base64Factory thiz);
            } Base64Factory;
            struct {
              libnative_KType* (*_type)(void);
              libnative_kref_xyz_sfx_base64_NativeBase64Encoder (*_instance)();
              libnative_kref_kotlin_ByteArray (*encode)(libnative_kref_xyz_sfx_base64_NativeBase64Encoder thiz, libnative_kref_kotlin_ByteArray src);
            } NativeBase64Encoder;
          } base64;
          struct {
            const char* (*get_globalString)();
            void (*forFloats)(libnative_KFloat f, libnative_KDouble d);
            void (*forIntegers)(libnative_KByte b, libnative_KShort s, libnative_KUInt i, libnative_KLong l);
            const char* (*strings)(const char* str);
            struct {
              libnative_KType* (*_type)(void);
              libnative_kref_xyz_sfx_utils_Clazz (*Clazz)();
              libnative_KULong (*memberFunction)(libnative_kref_xyz_sfx_utils_Clazz thiz, libnative_KInt p);
            } Clazz;
            struct {
              libnative_KType* (*_type)(void);
              libnative_kref_xyz_sfx_utils_Object (*_instance)();
              const char* (*get_field)(libnative_kref_xyz_sfx_utils_Object thiz);
            } Object;
          } utils;
          struct {
            struct {
              struct {
                const char* (*randomPassword)();
              } utils;
            } sfx;
          } xyz;
        } sfx;
      } xyz;
    } root;
  } kotlin;
} libnative_ExportedSymbols;
extern libnative_ExportedSymbols* libnative_symbols(void);
#ifdef __cplusplus
}  /* extern "C" */
#endif
#endif  /* KONAN_LIBNATIVE_H */
