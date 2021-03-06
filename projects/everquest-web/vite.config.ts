import { defineConfig } from 'vite'
import path from "path";
import * as fs from "fs";
import { visualizer } from 'rollup-plugin-visualizer';
import strip from '@rollup/plugin-strip';

const config = defineConfig({
  plugins:[
    visualizer({
      filename: 'dist/status.html'
    }),
    strip({}),
    // commonjs(),
    // nodeResolve(),
  ],
  base: "/",
  server: {
    hmr: {overlay: false },
  },
  build: {
    emptyOutDir: true,
    outDir: "dist",
    commonjsOptions: {
      esmExternals: true,
    },
    rollupOptions: {
      //input: ["src/main.tsx", "src/main.scss"],
      input: ["index.html"],
      output: {
        entryFileNames: '[name].js',
        assetFileNames: '[name].css',
        dir: path.resolve(__dirname, 'dist'),
        format: 'esm',
        manualChunks(id) {
          // 每个npm包一个chunk
          if (id.includes('node_modules')) {
            const idArray = id.split('/');
            const index = idArray.indexOf('node_modules');
            if(idArray.length > index + 1) {
              return idArray[index + 1];
            }
          }
        }
      }
      //input: listFile(path.resolve(__dirname, 'src/pages')),
      //input: ["index.html"],
    },
  },
  resolve: {
    alias: [
      { find: '@', replacement: path.resolve(__dirname, 'src') },
      { find: '~', replacement: path.resolve(__dirname, 'node_modules') }
    ]
  },
  publicDir: "public",
  css: {
    preprocessorOptions: {}
  }
})

export default config;
