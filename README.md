
# react-native-status-bar-color

## Getting started

`$ npm install react-native-status-bar-color --save`

### Mostly automatic installation

`$ react-native link react-native-status-bar-color`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.ninthsemeter.reactnative.statusBarColor.RNStatusBarColorPackage;` to the imports at the top of the file
  - Add `new RNStatusBarColorPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-status-bar-color'
  	project(':react-native-status-bar-color').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-status-bar-color/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-status-bar-color')
  	```


## Usage
```javascript
import RNStatusBarColor from 'react-native-status-bar-color';

// TODO: What to do with the module?
RNStatusBarColor;
```
  