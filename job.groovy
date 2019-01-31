job('after tests') {
    triggers {
        upstream('test', 'SUCCESSFUL')
    }
}