var endTime = function (time, expr) {
    if ( expr.tag === 'note' ) {
        return time + expr.dur;
    } else if ( expr.tag === 'seq' ) {
        return endTime(time, expr.left) + endTime(time, expr.right);
    }
};
