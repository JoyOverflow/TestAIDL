# 设置CMake构建本地库所需的最低版本
cmake_minimum_required(VERSION 3.4.1)

#将指定源文件编译成指定so库文件，保存为ouyang.so
add_library(
    ouyang
    SHARED
    src/main/jni/Sample.cpp
)

#搜索系统环境指定的变量路径
find_library(
    log-lib
    log
)

#指定链接输出库的名称
target_link_libraries(
    ouyang
    ${log-lib}
)
