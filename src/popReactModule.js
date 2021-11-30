import {NativeModules} from 'react-native';

export const testMethod = params => {
  NativeModules.PopReactModule
    .testMethod()
    .then(res => console.log('res', res))
    .catch(value => {
      console.log('value :>> ', value);
    });
};
