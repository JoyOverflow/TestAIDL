#include <jni.h>
#include <string>
#include "ouyj_hyena_com_demondk_MainActivity.h"

extern "C" JNIEXPORT jstring
JNICALL Java_ouyj_hyena_com_demondk_MainActivity_test1 (JNIEnv *env, jobject){
    std::string str = "test1";
    return env->NewStringUTF(str.c_str());
}

extern "C" JNIEXPORT jstring
JNICALL Java_ouyj_hyena_com_demondk_MainActivity_test2 (JNIEnv *env, jobject){
    std::string str = "test2";
    return env->NewStringUTF(str.c_str());
}