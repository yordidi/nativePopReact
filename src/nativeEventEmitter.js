import {NativeEventEmitter, NativeModules} from 'react-native';

export default new NativeEventEmitter(NativeModules.PopReactModule);
