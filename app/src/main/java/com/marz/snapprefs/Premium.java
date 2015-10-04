package com.marz.snapprefs;

import android.content.Context;
import android.content.res.XModuleResources;

import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;

public class Premium {
    static void initReplay(final XC_LoadPackage.LoadPackageParam lpparam, final XModuleResources modRes, final Context snapContext) {
        findAndHookMethod("auz", lpparam.classLoader, "d", XC_MethodReplacement.returnConstant(true));
        findAndHookMethod("aue", lpparam.classLoader, "y", XC_MethodReplacement.returnConstant(false));
        findAndHookMethod("aue", lpparam.classLoader, "u", XC_MethodReplacement.returnConstant(false));
        //findAndHookMethod("aty", lpparam.classLoader, "b",XC_MethodReplacement.DO_NOTHING);

        //findAndHookMethod("ate", lpparam.classLoader, "o", XC_MethodReplacement.DO_NOTHING);
        //findAndHookMethod("ate", lpparam.classLoader, "A", XC_MethodReplacement.DO_NOTHING);
        //findAndHookConstructor("uu", lpparam.classLoader, XC_MethodReplacement.DO_NOTHING);
        //findAndHookMethod("yy", lpparam.classLoader, "execute", XC_MethodReplacement.DO_NOTHING);
    }

    static void initTyping(final XC_LoadPackage.LoadPackageParam lpparam, final XModuleResources modRes, final Context snapContext) {
        findAndHookMethod("com.snapchat.android.model.chat.ChatConversation", lpparam.classLoader, "e", boolean.class, XC_MethodReplacement.DO_NOTHING);
        findAndHookMethod("com.snapchat.android.model.chat.ChatConversation", lpparam.classLoader, "b", boolean.class, XC_MethodReplacement.DO_NOTHING);
    }

    static void initViewed(final XC_LoadPackage.LoadPackageParam lpparam, final XModuleResources modRes, final Context snapContext) {
        Class<?> ate = findClass("aue", lpparam.classLoader);
        findAndHookMethod("auz", lpparam.classLoader, "a", ate, XC_MethodReplacement.DO_NOTHING);
    }
}
