import React from "react";

export function SummaryItem({clothesName, count}) {
    return (
        <div className="row">
            <h6 className="p-0">{clothesName} <span className="badge bg-dark text-">{count}개</span></h6>
        </div>
    )
}
