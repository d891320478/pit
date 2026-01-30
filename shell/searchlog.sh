#!/bin/bash

namespace=lianqiai-server
pods=$(kubectl get pod -n ${namespace} -o name | grep -i "$1" | sed 's|pod/||')

if [ -z "$pods" ]; then
    echo "未找到匹配的pod"
    exit 1
fi

echo "$pods" | while read pod; do
    if [ -n "$pod" ]; then
        echo "=== $pod ==="
        kubectl logs -n ${namespace} "$pod" | grep -i -C 20 "$2"
    fi
done
