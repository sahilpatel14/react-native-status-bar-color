import { Platform, StatusBar, NativeModules } from "react-native";

const { RNStatusBarColor } = NativeModules;

module.exports = {
  getAPILevel: () => {
    if (Platform.OS == "android") {
      return NavigationBar.apiLevel;
    }
  },
  setColor: color => {
    if (Platform.OS == "android" && NavigationBar.apiLevel >= 21) {
      return NavigationBar.setColor(color);
    }
  },

  setNavigationBarColor: (color, hasDarkTint) => {
    if (Platform.OS === "android") {
      NavigationBar.setNavigationBarColor(color, hasDarkTint);
    }
  },

  setStatusBarColor: (
    color,
    hasDarkTintAndroid,
    hasDarkTintIOS = hasDarkTintAndroid
  ) => {
    if (Platform.OS === "android") {
      NavigationBar.setStatusBarColor(color, hasDarkTintAndroid);
      StatusBar.setBarStyle(
        hasDarkTintAndroid ? "dark-content" : "light-content"
      );
    } else {
      StatusBar.setBarStyle(hasDarkTintIOS ? "dark-content" : "light-content");
    }
  },
  setStatusBarTheme: (theme, animation) => {
    if (theme == "light") {
      return StatusBar.setBarStyle("light-content", animation);
    }
    if (theme == "dark") {
      return StatusBar.setBarStyle("dark-content", animation);
    }
    return StatusBar.setBarStyle("default", animation);
  }
};
