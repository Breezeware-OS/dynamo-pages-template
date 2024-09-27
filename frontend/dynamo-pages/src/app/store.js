import {configureStore, getDefaultMiddleware} from '@reduxjs/toolkit';
import DocsSlice from '../screens/docs/DocsSlice';

const store = configureStore({
  middleware: [
    ...getDefaultMiddleware({
      serializableCheck: false,
    }),
  ],
  reducer: {
    docs: DocsSlice,
  },
});

export default store;
